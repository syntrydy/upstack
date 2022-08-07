package com.upstack.test.service.impl;

import com.upstack.test.domain.User;
import com.upstack.test.repository.DataStore;
import com.upstack.test.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public boolean doLogin(User user) {
    return DataStore.getInstance().getData().getUsers().stream()
        .anyMatch(c -> c.getUsername().equalsIgnoreCase(user.getUsername()) && c.getPassword()
            .equalsIgnoreCase(user.getPassword()));
  }

  @Override
  public boolean doSaveUser(User user) {
    return DataStore.getInstance().getData().addUser(user);
  }

  @Override
  public List<User> getUsers() {
    return DataStore.getInstance().getData().getUsers();
  }
}
