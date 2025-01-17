package com.example.IntensiveContext.Exceptions;

/** Исключение выбрасывается, если у искомого интерфейса более одной реализации. */
public class InterfaceHasMoreThanOneImplementation extends RuntimeException{
  /**
   * Конструктор, принимающий на вход сообщение в виде String.
   * @param errorMessage - сообщение об ошибке.
   */
  public InterfaceHasMoreThanOneImplementation(String errorMessage){
    super(errorMessage);
  }

}
