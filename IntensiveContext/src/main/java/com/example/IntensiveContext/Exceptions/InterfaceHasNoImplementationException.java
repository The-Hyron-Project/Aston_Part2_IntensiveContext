package com.example.IntensiveContext.Exceptions;

/** Исключение выбрасывается, если у искомого интерфейса нет ни одной реализации. */
public class InterfaceHasNoImplementationException extends RuntimeException{
  /**
   * Конструктор, принимающий на вход сообщение в виде String.
   * @param errorMessage - сообщение об ошибке.
   */
  public InterfaceHasNoImplementationException(String errorMessage){
    super(errorMessage);
  }
}
