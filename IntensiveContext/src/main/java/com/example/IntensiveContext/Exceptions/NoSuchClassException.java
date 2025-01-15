package com.example.IntensiveContext.Exceptions;

public class NoSuchClassException extends RuntimeException{
 public NoSuchClassException(String errorMessage){
   super(errorMessage);
 }
}
