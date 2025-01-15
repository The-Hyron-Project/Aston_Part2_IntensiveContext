package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Annotations.IntensiveComponent;
import com.example.IntensiveContext.Interfaces.AnnotationSearch;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationSearchImpl implements AnnotationSearch {

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
}
