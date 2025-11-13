package com.efub.livin.house.service;

import com.efub.livin.house.domain.Document;
import com.efub.livin.house.domain.House;
import com.efub.livin.house.dto.response.KakaoResponseDto;
import com.efub.livin.house.dto.request.HouseCreateRequest;
import com.efub.livin.house.dto.response.HouseResponse;
import com.efub.livin.house.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final KakaoApiClient kakaoApiClient;

    // 새 자취/하숙 정보 등록
    @Transactional
    public HouseResponse addHouse(HouseCreateRequest request){
        House house = House.create(request);

        // 주소 -> 좌표 변환
        KakaoResponseDto addressResponse = kakaoApiClient.searchAddress(request.getAddress());
        if (addressResponse != null && addressResponse.getDocuments() != null && !addressResponse.getDocuments().isEmpty()) {
            // 결과의 좌표를 엔티티에 저장
            Document doc = addressResponse.getDocuments().get(0);
            house.setLat(doc.getY()); // 위도
            house.setLon(doc.getX()); // 경도
        }

        House savedHouse = houseRepository.save(house);

        return HouseResponse.from(savedHouse);
    }
}
