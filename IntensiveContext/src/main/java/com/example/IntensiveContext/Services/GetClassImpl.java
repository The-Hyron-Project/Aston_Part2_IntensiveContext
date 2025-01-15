package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.GetClass;

public class GetClassImpl implements GetClass {

  GetClassImpl(){}

  @Override
  public Class<?> createClass(String packageName) {
    Class<?> clazz;
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    try {
      clazz = classLoader.loadClass(packageName);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return clazz;
  }
}
