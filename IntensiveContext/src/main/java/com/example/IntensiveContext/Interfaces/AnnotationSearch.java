package com.example.IntensiveContext.Interfaces;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface AnnotationSearch {
  boolean isClassAnnotated(Class<?> clazz);
  boolean areFieldsAnnotated(Class<?> clazz);
  ArrayList<Field> getAnnotatedFields(Class<?> clazz);
}
