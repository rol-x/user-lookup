package com.codeshop.userlookup.rest;

import com.codeshop.userlookup.model.User;
import com.codeshop.userlookup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
  private final UserService userService;

  @Override
  public User getUserData(String login) {
    return userService.getUserData(login);
  }
}
