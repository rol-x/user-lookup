package com.codeshop.userlookup.client.github;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GithubFeignClientTest {
  @Autowired GithubFeignClient githubFeignClient;

  @Test
  void getUserData() {
    // Given
    var login = "rol-x";

    // When
    var user = githubFeignClient.getUser(login);

    // Then
    assertThat(user.getLogin()).isEqualTo(login);
    assertThat(user.getId()).isNotNull();
    assertThat(user.getName()).isNotNull();
    assertThat(user.getType()).isNotNull();
    assertThat(user.getAvatarUrl()).isNotNull();
    assertThat(user.getCreatedAt()).isNotNull();
    assertThat(user.getFollowers()).isNotNull();
    assertThat(user.getPublicRepos()).isNotNull();
  }
}
