package com.codeshop.userlookup.client.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github", url = "${client.github.url}")
public interface GithubFeignClient {

  @GetMapping("/users/{login}")
  GithubUser getUser(@PathVariable String login);
}
