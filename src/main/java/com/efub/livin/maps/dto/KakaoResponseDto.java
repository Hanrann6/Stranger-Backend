package com.efub.livin.maps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.efub.livin.maps.domain.Document;

import java.util.List;

@Getter
@AllArgsConstructor
public class KakaoResponseDto {

    private List<Document> documents;
}
