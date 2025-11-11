package com.efub.livin.maps.service;

import com.efub.livin.maps.domain.HouseType;
import lombok.RequiredArgsConstructor;
import com.efub.livin.maps.domain.Document;
import com.efub.livin.maps.domain.House;
import com.efub.livin.maps.dto.KakaoResponseDto;
import com.efub.livin.maps.repository.HouseSaveRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.efub.livin.maps.domain.HouseType.BOARDING;
import static com.efub.livin.maps.domain.HouseType.PRIVATE;

@Service
@RequiredArgsConstructor
public class HouseSaveService {

    private final KakaoApiClient kakaoApiClient;
    private final HouseSaveRepository houseSaveRepository;

    private static final List<String> KEYWORDS = List.of("자취", "고시원", "고시텔", "쉐어하우스", "하숙");

    public void syncAndSave(){

        // 키워드별로 데이터 저장
        for(String keyword : KEYWORDS){
            KakaoResponseDto response = kakaoApiClient.searchByKeyword(keyword);
            //KakaoResponseDto response = kakaoApiClient.searchByKeyword(keyword);
            List<Document> documents = response.getDocuments();

            if (documents == null || documents.isEmpty()) {
                System.out.println(keyword + " 검색 결과 없음");
                continue;
            }

            for(Document document : documents){
                HouseType type;

                if(keyword.equals("자취") || keyword.equals("고시원") || keyword.equals("고시텔")){
                    type = PRIVATE;
                } else { // 하숙
                    type = BOARDING;
                }
                // House 엔티티로 변환
                House house = House.from(document, type);

                // DB에 저장
                houseSaveRepository.save(house);
            }


        }

    }


}
