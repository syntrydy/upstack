package com.upstack.test.controller;

import com.upstack.test.service.UserService;
import com.upstack.test.uidomain.UIResponse;
import com.upstack.test.uidomain.UserViewObject;
import com.upstack.test.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/users/login")
  public ResponseEntity<UIResponse> login(@RequestBody UserViewObject userViewObject) {
    if (Utils.isValidLoginRequest(userViewObject)) {
      System.out.println("=========================================");
      return new ResponseEntity<>(new UIResponse(userService.doLogin(userViewObject)),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new UIResponse(false), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/users/save")
  public ResponseEntity<UIResponse> save(@RequestBody UserViewObject userViewObject) {
    if (Utils.isValidSaveRequest(userViewObject)) {
      return new ResponseEntity<>(new UIResponse(userService.doSaveUser(userViewObject)),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new UIResponse(false), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/users")
  public ResponseEntity<Object> getUsers() {
    return new ResponseEntity<>(userService.getUsers(),
        HttpStatus.OK);
  }

}
