package com.example.IntensiveContext.Exceptions;

/** Исключение выбрасывается, если искомый класс не найден или не помечен аннотацией @IntensiveComponent. */
public class NoSuchClassException extends RuntimeException{
  /**
   * Конструктор, принимающий на вход сообщение в виде String.
   * @param errorMessage - сообщение об ошибке.
   */
 public NoSuchClassException(String errorMessage){
   super(errorMessage);
 }
}
