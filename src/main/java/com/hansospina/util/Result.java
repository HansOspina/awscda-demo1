package com.hansospina.util;


import java.util.HashMap;
import java.util.Map;

public final class Result {

  private HashMap<String, Object> json = new HashMap<>();

  private Result self;

  private boolean success = true;

  private Result() {
    this.self = this;
  }

  public static Result withSuccess() {
    return new Result();
  }

  public static Result withError(String message) {
    return new Result().error(message);
  }

  public Result merge(Map<String, Object> items) {
    self.json.putAll(items);

    if (items.containsKey("error")) {
      self.success = false;
    }

    return self;
  }

  public Result merge(Result items) {
    return self.merge(items.json());
  }


  public Result set(String key, Object value) {
    self.json.put(key, value);
    return self;
  }

  public Result error(String message) {
    self.success = false;
    self.json.put("message", message);
    return self;
  }

  public HashMap<String, Object> json() {
    json.put("success", self.success);
    return json;
  }

  public boolean isSuccess() {
    return success;
  }

}