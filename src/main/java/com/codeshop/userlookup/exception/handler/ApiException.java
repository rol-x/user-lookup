package com.codeshop.userlookup.exception.handler;

import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class ApiException extends RuntimeException {
  protected final FeignException inner;
  protected final HttpStatus status;
  protected final String message;
}
