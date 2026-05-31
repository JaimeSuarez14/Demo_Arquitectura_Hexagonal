package com.example.demotest.common.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {
  private String exception;
  private String message;
  private String path;
  private Map<String, String> errors;

  public ErrorMessage(String exception, String message, String path, Map<String, String> errors) {
    this.exception = exception;
    this.message = message;
    this.path = path;
    this.errors = errors;
  }

  public ErrorMessage(String exception, String message, String path) {
    this.exception = exception;
    this.message = message;
    this.path = path;
    this.errors = new HashMap<>();
  }

  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Map<String, String> getErrors() {
    return errors;
  }

  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }

}
