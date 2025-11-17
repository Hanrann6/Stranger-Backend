package com.efub.livin.review.repository;

import com.efub.livin.review.domain.DormReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseReviewRepository extends JpaRepository<DormReview, Long> {

    List<DormReview> findAllByOrderByCreatedAtDesc();

}
