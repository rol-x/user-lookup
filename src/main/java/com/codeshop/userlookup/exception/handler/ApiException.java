package com.codeshop.userlookup.exception.handler;

import feign.FeignException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException {
  protected FeignException inner;
  protected HttpStatus status;
  protected String message;
}
