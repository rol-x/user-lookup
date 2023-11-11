package com.codeshop.userlookup.service;

import com.codeshop.userlookup.client.UserProvider;
import com.codeshop.userlookup.model.User;
import com.codeshop.userlookup.repository.RequestsRepository;
import com.codeshop.userlookup.repository.entity.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserProvider githubUserProvider;
  private final RequestsRepository requestsRepository;

  public User getUserData(String login) {
    var user = githubUserProvider.getUserData(login);
    requestsRepository.save(
        requestsRepository.findByLogin(login).orElse(LoginRequest.build(login)).incrementCounter());
    return user;
  }
}
