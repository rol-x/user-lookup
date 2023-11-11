package com.codeshop.userlookup.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class ApiException extends RuntimeException {
  protected final HttpStatus status;
  protected final String message;
  protected final String details;
}
