package com.threesteps.acpapi.exception;

import com.threesteps.acpapi.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponseDto<?> handle(NotFoundException exception) {
        return new ApiResponseDto<>(exception.getMessage(), null);
    }

    @ExceptionHandler(TokenNotVerifiedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponseDto<?> handle(TokenNotVerifiedException exception) {
        return new ApiResponseDto<>(exception.getMessage(), null);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponseDto<?> handle(TokenNotFoundException exception) {
        return new ApiResponseDto<>(exception.getMessage(), null);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDto<?> handle(BadCredentialsException exception) {
        return new ApiResponseDto<>(exception.getMessage(), null);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDto<?> handle(UserAlreadyExistsException exception) {
        return new ApiResponseDto<>(exception.getMessage(), null);
    }

}