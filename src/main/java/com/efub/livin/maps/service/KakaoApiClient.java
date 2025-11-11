package com.efub.livin.maps.service;

import com.efub.livin.maps.dto.KakaoResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class KakaoApiClient {

    @Value("${kakao.map.KAKAO_API_KEY}")
    private String kakaoApiKey;

    @Value("${kakao.map.KAKAO_API_URL}")
    private String kakaoApiUrl;

    public KakaoResponseDto searchByKeyword(String keyword) {

        String x = "126.95"; // 중심 경도
        String y = "37.56"; // 중심 위도
        Integer radius = 1500; // 반경. 단위(m). 1.5km

        // 카카오 요청 url
        String url = kakaoApiUrl + "?query={keyword}";
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("x", x);
        params.put("y", y);
        params.put("radius", radius);

        RestTemplate restTemplate = new RestTemplate();

        // Header 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Kakao API 호출
        ResponseEntity<KakaoResponseDto> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                KakaoResponseDto.class,
                params
        );

        return response.getBody();
    }
}
