package com.codeshop.userlookup.client;

import com.codeshop.userlookup.model.User;

public interface UserProvider {
  User getUserData(String login);
}
