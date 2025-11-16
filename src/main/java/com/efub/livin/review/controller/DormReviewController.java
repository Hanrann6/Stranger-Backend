package com.efub.livin.review.controller;

import com.efub.livin.review.dto.request.DormCreateRequestDto;
import com.efub.livin.review.service.DormReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dorm/review")
public class DormReviewController {

    private final DormReviewService dormReviewService;

    @PostMapping
    public ResponseEntity<Long> createDormReview(
            @RequestBody DormCreateRequestDto request
            ) {
        Long id = dormReviewService.createDormReview(request);
        return ResponseEntity.ok(id);
    }
}
