package com.codeshop.userlookup.exception;

import com.codeshop.userlookup.exception.handler.ApiException;
import feign.FeignException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserLoginNotFoundException extends ApiException {
  public static final String MESSAGE_TEMPLATE = "User identified by login %s does not exist.";

  public UserLoginNotFoundException(FeignException inner, String login) {
    super(inner, HttpStatus.NOT_FOUND, MESSAGE_TEMPLATE.formatted(login));
  }
}
