package com.efub.livin.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED_ACCESS(401, "인증되지 않은 사용자입니다.");

    private final int status;
    private final String message;
}
