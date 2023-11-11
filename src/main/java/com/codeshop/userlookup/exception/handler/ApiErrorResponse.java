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
    this.status = exception.getStatus().value();
    this.error = exception.getStatus().getReasonPhrase();
    this.message = exception.getMessage();
    this.details = exception.getDetails();
  }

  public ApiErrorResponse(HttpStatus status, String message, RuntimeException exception) {
    this.timestamp = Instant.now();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.details = exception.getMessage();
  }
}
