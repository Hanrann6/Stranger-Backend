package com.efub.livin.review.repository;

import com.efub.livin.review.domain.DormReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormReviewRepository extends JpaRepository<DormReview, Long> {
}
