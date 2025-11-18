package com.efub.livin.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED_ACCESS(401, "인증되지 않은 사용자입니다."),

    // 회원 가입 관련
    NICKNAME_DUPLICATED(409, "이미 존재하는 닉네임입니다."),
    EMAIL_NOT_VERIFIED(400, "해당 이메일로 요청한 사용자 정보가 없습니다."),

    // House 저장 관련
    KAKAO_API_ERROR(500, "카카오 API 연동 중 오류가 발생했습니다."),
    KAKAO_API_EMPTY_RESPONSE(500, "카카오 API로부터 빈 응답을 받았습니다.");


    private final int status;
    private final String message;
}
