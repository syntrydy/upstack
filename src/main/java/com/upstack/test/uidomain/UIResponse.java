package com.upstack.test.uidomain;

public class UIResponse {

  public UIResponse() {
  }
  public UIResponse(boolean result) {
    this.result = result;
  }
  boolean result;

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }
}
