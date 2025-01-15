package com.example.IntensiveContext.Exceptions;

public class InterfaceHasNoImplementationException extends RuntimeException{
  public InterfaceHasNoImplementationException(String errorMessage){
    super(errorMessage);
  }
}
