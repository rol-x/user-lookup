package com.codeshop.userlookup.client.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Getter;

@Getter
public class GithubUser {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("login")
  private String login;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private String type;

  @JsonProperty("followers")
  private Integer followers;

  @JsonProperty("public_repos")
  private Integer publicRepos;

  @JsonProperty("avatar_url")
  private String avatarUrl;

  @JsonProperty("created_at")
  private Instant createdAt;
}
