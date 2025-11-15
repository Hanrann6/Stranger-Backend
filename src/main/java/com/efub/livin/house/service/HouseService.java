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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final KakaoApiClient kakaoApiClient;
    private final ImageService imageService;

    // 새 자취/하숙 정보 등록
    @Transactional
    public HouseResponse addHouse(HouseCreateRequest request) {

        // 주소 -> 좌표 변환
        Document doc = kakaoApiClient.searchAddress(request.getAddress()).getDocuments().get(0);

        // House 저장
        House house = House.create(request, doc.getX(), doc.getY());
        House savedHouse = houseRepository.save(house);

        return HouseResponse.from(savedHouse);
    }
}
