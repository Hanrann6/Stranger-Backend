package com.efub.livin.global.exception.dto;

import java.time.LocalDateTime;

public record ErrorDto(String errorCode,
                       LocalDateTime timestamp,
                       String message,
                       int status,
                       String path) {
}
