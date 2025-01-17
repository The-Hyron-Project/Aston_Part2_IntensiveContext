package com.example.IntensiveContext.Interfaces;

/** Интерфейс, описывающий поведение классов, создающих объекты. */
public interface CreateObject {

  /** Метод, возвращающий объект типа Т.
   * @param clazz - класс, объект которого нужно создать.
   * @return - объект типа Т.
   */
  <T> T createObject(Class<?> clazz);
}
