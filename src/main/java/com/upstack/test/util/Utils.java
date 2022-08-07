package com.upstack.test.util;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.upstack.test.uidomain.UserViewObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class Utils {

  private Utils(){}

  public static boolean isValidLoginRequest(UserViewObject user){
    return user!=null && user.getUsername()!=null && user.getPassword()!=null;
  }

  public static boolean isValidSaveRequest(UserViewObject user){
    return user!=null && user.getPassword()!=null && user.getUsername()!=null;
  }

  public static String asString(Resource resource) {
    try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
      return FileCopyUtils.copyToString(reader);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
