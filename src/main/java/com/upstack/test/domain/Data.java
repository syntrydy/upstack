package com.upstack.test.domain;

import java.util.ArrayList;
import java.util.List;

public class Data {

  private List<User> users = new ArrayList<>();

  public Data() {
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public boolean addUser(User user) {
    if (user != null) {
      users.remove(user);
      users.add(user);
      return true;
    }
    return false;
  }
}
