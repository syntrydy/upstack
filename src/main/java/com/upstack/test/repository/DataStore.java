package com.upstack.test.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstack.test.domain.Data;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class DataStore {

  private static final Logger logger = LoggerFactory.getLogger(DataStore.class.getName());

  private static  Data data;

  private static DataStore instance;
  private DataStore(){
  }

  public static DataStore getInstance(){
    if(instance==null){
      instance=new DataStore();
      data= init();
    }
    return instance;
  }


  private static Data init() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File file = ResourceUtils.getFile("classpath:users.json");
      return objectMapper.readValue(file, Data.class);
    } catch (IOException exception) {
      logger.info("error loading json file",exception);
      return new Data();
    }
  }

  public static Data getData() {
    return data;
  }
}
