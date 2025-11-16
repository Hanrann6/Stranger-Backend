package com.efub.livin.review.service;

import com.efub.livin.review.domain.DormReview;
import com.efub.livin.review.domain.ReviewImage;
import com.efub.livin.review.dto.request.DormCreateRequestDto;
import com.efub.livin.review.repository.DormReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DormReviewService {

    private final DormReviewRepository dormReviewRepository;

    @Transactional
    public long createDormReview(DormCreateRequestDto request){
        DormReview review = request.toEntity();

        //이미지가 있다면 엔티티와 연결
        if(request.getImageUrls() != null) {
            request.getImageUrls().forEach(url -> {
                ReviewImage images = new ReviewImage(url);
                review.addImage(images);
            });
        }

        DormReview saved = dormReviewRepository.save(review);

        return saved.getId();
    }
}
