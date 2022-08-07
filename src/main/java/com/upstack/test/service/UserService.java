package com.upstack.test.service;


import com.upstack.test.domain.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  boolean doLogin(User user);

  boolean doSaveUser(User user);

  List<User> getUsers();
}
