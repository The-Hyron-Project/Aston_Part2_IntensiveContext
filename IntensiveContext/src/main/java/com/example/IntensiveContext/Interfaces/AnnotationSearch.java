package com.example.IntensiveContext.Interfaces;

import java.lang.reflect.Field;
import java.util.ArrayList;

/** Интерфейс, описывающий поведение классов, ищущих аннотации в других классах. */
public interface AnnotationSearch {
  /** Метод, возвращающий булево значение.
   * @param clazz - класс, который нужно проверить на наличие аннотации @IntensiveComponent.
   * @return - булевое значение.
   */
  boolean isClassAnnotated(Class<?> clazz);

  /** Метод, возвращающий булево значение.
   * @param clazz - класс, классы полей которого нужно проверить на наличие аннотации @IntensiveComponent.
   * @return - булевое значение.
   */
  boolean areFieldsAnnotated(Class<?> clazz);

  /** Метод, возвращающий список полей.
   * Классы полей должны быть аннотированы @IntensiveComponent.
   * @param clazz - класс, поля которого нужно вернуть.
   * @return - объект типа ArrayList, содержащий объекты типа Field.
   */
  ArrayList<Field> getAnnotatedFields(Class<?> clazz);
}
