package com.codeshop.userlookup.exception.handler;

import com.codeshop.userlookup.exception.UserLoginNotFoundException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserLoginNotFoundException.class)
  protected ResponseEntity<ApiErrorResponse> handleUserLoginNotFoundException(
      UserLoginNotFoundException exception, WebRequest request) {
    return ResponseEntity.status(exception.getStatus()).body(new ApiErrorResponse(exception));
  }

  @ExceptionHandler(FeignException.class)
  protected ResponseEntity<ApiErrorResponse> handleFeignException(
      FeignException exception, WebRequest request) {
    return ResponseEntity.status(exception.status())
        .body(new ApiErrorResponse(HttpStatus.valueOf(exception.status()), exception));
  }
}
