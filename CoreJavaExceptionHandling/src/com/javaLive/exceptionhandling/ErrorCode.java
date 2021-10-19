package com.javaLive.exceptionhandling;

public enum ErrorCode {
	DATABASE(0, "A database error has occured."),
    DUPLICATE_USER(1, "This user already exists."),
	INVALID_PORT_CONFIGURATION(2, "Port is not properly configured."),
	INVALID_NUMBER_INPUT(3,"Invalid input to convert to number.");
	  private final int code;
	  private final String description;

	  private ErrorCode(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getDescription() {
	     return description;
	  }

	  public int getCode() {
	     return code;
	  }

	  @Override
	  public String toString() {
	    return code + ": " + description;
	  }
}
