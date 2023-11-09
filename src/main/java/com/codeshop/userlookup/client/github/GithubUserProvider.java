package com.codeshop.userlookup.client.github;

import com.codeshop.userlookup.client.UserProvider;
import com.codeshop.userlookup.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubUserProvider implements UserProvider {
  private final GithubFeignClient feignClient;

  @Override
  public User getUserData(String login) {
    var userResponse = feignClient.getUser(login);
    return User.fromGithubUser(userResponse);
  }
}
