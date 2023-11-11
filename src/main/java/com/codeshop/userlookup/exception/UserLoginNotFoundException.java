package com.codeshop.userlookup.exception;

import com.codeshop.userlookup.exception.handler.ApiException;
import feign.FeignException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserLoginNotFoundException extends ApiException {
  public static final String MESSAGE_TEMPLATE = "User identified by login %s does not exist.";
  public static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

  public UserLoginNotFoundException(FeignException cause, String login) {
    super(HTTP_STATUS, MESSAGE_TEMPLATE.formatted(login), cause.getMessage());
  }
}
