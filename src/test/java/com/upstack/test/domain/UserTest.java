package com.upstack.test.domain;

import org.assertj.core.api.*;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {

  private User objectToTest;

  @BeforeEach
  public void setup(){
    objectToTest= new User();
  }

  public void setUsernameTest(){
    objectToTest.setUsername("james");
  }

}
