package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Annotations.IntensiveComponent;
import com.example.IntensiveContext.Interfaces.AnnotationSearch;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/** Класс, реализующий AnnotationSearchImpl. */
public class AnnotationSearchImpl implements AnnotationSearch {
  /** Поле хранения инстанса AnnotationSearchImpl. */
  private static AnnotationSearchImpl INSTANCE;
  /** Приватный конструктор для создания объекта типа AnnotationSearchImpl. */
  private AnnotationSearchImpl(){};

  @Override
  public boolean isClassAnnotated(Class<?> clazz) {
    if(clazz.isAnnotationPresent(IntensiveComponent.class)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean areFieldsAnnotated(Class<?> clazz) {
      List<Field> classMemberFields = List.of(clazz.getDeclaredFields());
      for(Field field : classMemberFields){
        if(field.getType().isAnnotationPresent(IntensiveComponent.class)){
          return true;
        }
      }
    return false;
  }

  @Override
  public ArrayList<Field> getAnnotatedFields(Class<?> clazz) {
    ArrayList<Field> listOfFields = new ArrayList<>();
    List<Field> classMemberFields = List.of(clazz.getDeclaredFields());
    for(Field field : classMemberFields){
      if(field.getType().isAnnotationPresent(IntensiveComponent.class)){
        listOfFields.add(field);
      }
    }
    return listOfFields;
  }

  /** Метод для создания и получения инстанса AnnotationSearchImpl. */
  public static AnnotationSearchImpl getInstance(){
    if(INSTANCE==null){
      INSTANCE = new AnnotationSearchImpl();
    }
    return INSTANCE;
  }
}
