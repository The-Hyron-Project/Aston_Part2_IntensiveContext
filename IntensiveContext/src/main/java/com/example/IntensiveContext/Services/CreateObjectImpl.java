package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.CreateObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CreateObjectImpl implements CreateObject {
  AnnotationSearchImpl annotationSearch = new AnnotationSearchImpl();


  @Override
  public <T> T createObject(Class<?> clazz) {
    Object obj;
    Constructor<?> constructor = clazz.getConstructors()[0];
    try {
      obj = constructor.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    return (T) obj;
  }
}
