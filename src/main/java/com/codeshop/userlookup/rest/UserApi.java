package com.codeshop.userlookup.rest;

import com.codeshop.userlookup.model.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/users")
public interface UserApi {

  @GetMapping("/{login}")
  @Operation(operationId = "getUserData")
  User getUserData(@PathVariable String login);
}
