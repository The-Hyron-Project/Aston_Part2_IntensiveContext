package com.example.IntensiveContext.Exceptions;

public class InterfaceHasMoreThanOneImplementation extends RuntimeException{
  public InterfaceHasMoreThanOneImplementation(String errorMessage){
    super(errorMessage);
  }

}
