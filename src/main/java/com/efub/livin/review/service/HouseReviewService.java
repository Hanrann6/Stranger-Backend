package com.efub.livin.review.service;

import com.efub.livin.global.exception.CustomException;
import com.efub.livin.house.domain.House;
import com.efub.livin.house.repository.HouseSaveRepository;
import com.efub.livin.review.dto.request.HouseReviewCreateRequestDto;
import com.efub.livin.review.repository.HouseReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseReviewService {
    private final HouseReviewRepository houseReviewRepository;
    private final HouseSaveRepository houseSaveRepository;

    //리뷰 생성
    @Transactional
    public Long createHouseReview(Long houseId, HouseReviewCreateRequestDto request){
        House house = houseSaveRepository.findById(houseId)
                .orElseThrow(()-> CustomException(ErrorCode.))
    }
}
