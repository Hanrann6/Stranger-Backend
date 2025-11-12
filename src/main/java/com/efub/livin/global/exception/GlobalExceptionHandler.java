package com.efub.livin.global.exception;

import com.efub.livin.global.exception.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorDto> handleCustomException(
            CustomException e, HttpServletRequest request){
        ErrorDto error = new ErrorDto(
                e.getErrorCode().name(),
                LocalDateTime.now(),
                e.getErrorCode().getMessage(),
                e.getErrorCode().getStatus(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }
}
