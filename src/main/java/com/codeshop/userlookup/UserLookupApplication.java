package com.codeshop.userlookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserLookupApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserLookupApplication.class, args);
  }
}
