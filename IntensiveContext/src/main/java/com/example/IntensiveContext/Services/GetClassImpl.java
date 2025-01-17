package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.GetClass;

/** Класс, реализующий GetClass. */
public class GetClassImpl implements GetClass {
  /** Поле хранения инстанса GetClassImpl. */
  private static GetClassImpl INSTANCE;

  /** Приватный конструктор для создания объекта типа GetClassImpl. */
  private GetClassImpl(){}

  @Override
  public Class<?> createClass(String className) {
    Class<?> clazz;
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    try {
      clazz = classLoader.loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return clazz;
  }

  /** Метод для создания и получения инстанса getInstance. */
  public static GetClassImpl getInstance(){
    if(INSTANCE==null){
      INSTANCE = new GetClassImpl();
    }
    return INSTANCE;
  }
}
