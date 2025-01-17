package com.example.IntensiveContext.Interfaces;

/** Интерфейс, описывающий поведение классов, создающий классы из файлов типа .class. */
public interface GetClass {
  /** Метод, возвращающий класс.
   * @param className - имя класса, который нужно создать.
   * @return - класс типа Т.
   */
  <T> T createClass(String className);
}
