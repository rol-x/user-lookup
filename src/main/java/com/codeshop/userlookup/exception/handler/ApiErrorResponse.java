package com.codeshop.userlookup.exception.handler;

import java.time.Instant;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiErrorResponse {
  private final Instant timestamp;
  private final int status;
  private final String error;
  private final String message;
  private final String details;

  public ApiErrorResponse(ApiException exception) {
    this.timestamp = Instant.now();
    this.status = exception.status.value();
    this.error = exception.status.getReasonPhrase();
    this.message = exception.message;
    this.details = exception.inner.getMessage();
  }

  public ApiErrorResponse(HttpStatus status, RuntimeException exception) {
    this.timestamp = Instant.now();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = "Something went wrong during a call to external service.";
    this.details = exception.getMessage();
  }
}
