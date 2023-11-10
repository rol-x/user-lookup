package com.codeshop.userlookup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codeshop.userlookup.exception.UserLoginNotFoundException;
import com.codeshop.userlookup.repository.LoginRequest;
import com.codeshop.userlookup.repository.RequestsRepository;
import com.codeshop.userlookup.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserLookupApplicationTests {
  @Autowired UserService userService;
  @Autowired RequestsRepository requestsRepository;

  @Test
  @Transactional
  void getUserDataPath_ok() {
    // Given
    var login = "rol-x";
    var countBefore =
        requestsRepository.findByLogin(login).orElse(LoginRequest.build(login)).getRequestCount();

    // When
    var user = userService.getUserData(login);

    // Then
    var loginRequestAfter = requestsRepository.findByLogin(login);
    assertThat(loginRequestAfter).isNotEmpty();
    assertThat(loginRequestAfter.get().getRequestCount()).isEqualTo(countBefore + 1);

    assertThat(user.getLogin()).isEqualTo(login);
    assertThat(user.getId()).isNotNull();
    assertThat(user.getName()).isNotNull();
    assertThat(user.getType()).isNotNull();
    assertThat(user.getAvatarUrl()).isNotNull();
    assertThat(user.getCreatedAt()).isNotNull();
    assertThat(user.getCalculations()).isNotNull();
  }

  @Test
  @Transactional
  void getUserDataPath_notFound() {
    // Given
    var login = "11111";

    // When & Then
    assertThrows(UserLoginNotFoundException.class, () -> userService.getUserData(login));
    assertThat(requestsRepository.findByLogin(login)).isEmpty();
  }
}
