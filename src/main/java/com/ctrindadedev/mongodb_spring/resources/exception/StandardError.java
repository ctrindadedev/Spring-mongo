package com.ctrindadedev.mongodb_spring.resources.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

   public StandardError(){};
   public StandardError(Long timestamp, String message, String path, Integer status, String error) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.path = path;
    this.status = status;
    this.error = error;
   }
}
