package com.efub.livin.review.repository;

import com.efub.livin.review.domain.HouseReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseReviewRepository extends JpaRepository<HouseReview, Long> {

    List<HouseReview> findByHouseIdOrderByCreatedAtDesc(Long houseId);

}
