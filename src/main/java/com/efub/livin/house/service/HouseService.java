package com.efub.livin.house.service;

import com.efub.livin.house.domain.House;
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

    // 새 자취/하숙 정보 등록
    @Transactional
    public HouseResponse addHouse(HouseCreateRequest request){
        House house = House.create(request);
        House savedHouse = houseRepository.save(house);

        return HouseResponse.from(savedHouse);
    }
}
