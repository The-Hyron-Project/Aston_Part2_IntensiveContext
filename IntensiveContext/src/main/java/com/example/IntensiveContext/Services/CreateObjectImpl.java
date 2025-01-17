package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.CreateObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** Класс, реализующий CreateObjectImpl. */
public class CreateObjectImpl implements CreateObject {
  /** Поле хранения инстанса CreateObjectImpl. */
  private static CreateObjectImpl INSTANCE;
  /** Поле хранения инстанса AnnotationSearchImpl. */
  AnnotationSearchImpl annotationSearch;

  /** Приватный конструктор для создания объекта типа CreateObjectImpl. */
  private CreateObjectImpl(){
    annotationSearch = AnnotationSearchImpl.getInstance();
  };

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

  /** Метод для создания и получения инстанса CreateObjectImpl. */
  public static CreateObjectImpl getInstance(){
    if(INSTANCE==null){
      INSTANCE = new CreateObjectImpl();
    }
    return INSTANCE;
  }
}
