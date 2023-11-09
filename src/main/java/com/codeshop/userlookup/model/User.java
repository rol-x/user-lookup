package com.codeshop.userlookup.model;

import com.codeshop.userlookup.client.github.GithubUser;
import java.time.Instant;
import lombok.Getter;

@Getter
public class User {
  private Long id;
  private String login;
  private String name;
  private String type;
  private String avatarUrl;
  private Instant createdAt;
  private Double calculations;

  public static User fromGithubUser(GithubUser userResponse) {
    var user = new User();
    user.id = userResponse.getId();
    user.login = userResponse.getLogin();
    user.name = userResponse.getName();
    user.type = userResponse.getType();
    user.avatarUrl = userResponse.getAvatarUrl();
    user.createdAt = userResponse.getCreatedAt();
    user.calculations = 6.0 * (2.0 + userResponse.getPublicRepos()) / userResponse.getFollowers();
    return user;
  }
}
