package com.example.IntensiveContext.Interfaces;

/** Интерфейс, описывающий поведение классов, ищущих классы. */
public interface SearchInterface {
  /** Метод, возвращающий класс.
   * @param package_name - пакет, в котором нужно выполнять поиск.
   * @param classType - класс, который нужно найти.
   * @return - класс типа ?.
   */
  Class<?> findClass(String package_name, Class<?> classType);

  /** Метод, возвращающий класс.
   * @param package_name - пакет, в котором нужно выполнять поиск.
   * @param classType - интерфейс, имплементацию которого нужно найти.
   * @return - класс типа ?, имплементирующий интерфейс classType.
   */
  public Class<?> findInterfaceImplementingClass(String package_name, Class<?> classType);
}
