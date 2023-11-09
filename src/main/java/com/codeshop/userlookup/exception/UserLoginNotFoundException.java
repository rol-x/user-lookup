package com.codeshop.userlookup.exception;

import com.codeshop.userlookup.exception.handler.ApiException;
import feign.FeignException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserLoginNotFoundException extends ApiException {

  public UserLoginNotFoundException(FeignException inner, String login) {
    this.inner = inner;
    this.status = HttpStatus.NOT_FOUND;
    this.message = "User identified by login %s does not exist.".formatted(login);
  }
}
