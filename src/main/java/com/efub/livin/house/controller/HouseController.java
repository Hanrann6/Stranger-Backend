package com.efub.livin.house.controller;

import com.efub.livin.house.domain.House;
import com.efub.livin.house.dto.request.HouseCreateRequest;
import com.efub.livin.house.dto.response.HouseResponse;
import com.efub.livin.house.service.HouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;

    // 새 자취/하숙 생성 컨트롤러
    @PostMapping(value = "/new")
    public ResponseEntity<HouseResponse> save(
            @Valid @RequestBody HouseCreateRequest request) {

        HouseResponse response = houseService.addHouse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
