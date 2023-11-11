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
  private static final String FEIGN_EXCEPTION_MESSAGE =
      "Something went wrong during a call to an external service.";
  private static final String GENERAL_EXCEPTION_MESSAGE = "Something went wrong.";

  @ExceptionHandler(UserLoginNotFoundException.class)
  protected ResponseEntity<ApiErrorResponse> handleUserLoginNotFoundException(
      UserLoginNotFoundException exception, WebRequest request) {
    return ResponseEntity.status(exception.getStatus()).body(new ApiErrorResponse(exception));
  }

  @ExceptionHandler(FeignException.class)
  protected ResponseEntity<ApiErrorResponse> handleFeignException(
      FeignException exception, WebRequest request) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ApiErrorResponse(
                HttpStatus.valueOf(exception.status()), FEIGN_EXCEPTION_MESSAGE, exception));
  }

  @ExceptionHandler(RuntimeException.class)
  protected ResponseEntity<ApiErrorResponse> handleGeneralException(
      RuntimeException exception, WebRequest request) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, GENERAL_EXCEPTION_MESSAGE, exception));
  }
}
