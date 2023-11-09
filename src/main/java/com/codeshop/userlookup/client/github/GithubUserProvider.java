package com.codeshop.userlookup.client.github;

import com.codeshop.userlookup.client.UserProvider;
import com.codeshop.userlookup.exception.UserLoginNotFoundException;
import com.codeshop.userlookup.model.User;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubUserProvider implements UserProvider {
  private final GithubFeignClient feignClient;

  @Override
  public User getUserData(String login) {
    try {
      var userResponse = feignClient.getUser(login);
      return User.fromGithubUser(userResponse);
    } catch (FeignException.NotFound exception) {
      throw new UserLoginNotFoundException(exception, login);
    }
  }
}
