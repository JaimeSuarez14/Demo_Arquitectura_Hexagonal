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

  
  
}
