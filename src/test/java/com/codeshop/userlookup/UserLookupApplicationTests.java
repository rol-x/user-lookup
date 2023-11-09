package com.codeshop.userlookup;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeshop.userlookup.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserLookupApplicationTests {
  @Autowired UserService userService;

  @Test
  void getUserData() {
    // Given
    var login = "rol-x";

    // When
    var user = userService.getUserData(login);

    // Then
    assertThat(user.getLogin()).isEqualTo(login);
    assertThat(user.getId()).isNotNull();
    assertThat(user.getName()).isNotNull();
    assertThat(user.getType()).isNotNull();
    assertThat(user.getAvatarUrl()).isNotNull();
    assertThat(user.getCreatedAt()).isNotNull();
    assertThat(user.getCalculations()).isNotNull();
  }
}
