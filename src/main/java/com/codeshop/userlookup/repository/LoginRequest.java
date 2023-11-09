package com.codeshop.userlookup.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;

@Table(name = "LOGIN_REQUEST")
@Getter
@Entity
public class LoginRequest {
  // TODO Separate column for ID or LOGIN as primary key?
  @Column(name = "ID")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "LOGIN")
  private String login;

  @Column(name = "REQUEST_COUNT")
  private int requestCount;

  public LoginRequest incrementCounter() {
    this.requestCount++;
    return this;
  }

  public static LoginRequest build(String login) {
    var request = new LoginRequest();
    request.login = login;
    request.requestCount = 0;
    return request;
  }
}
