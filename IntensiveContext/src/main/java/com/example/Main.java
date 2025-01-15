package com.example;

import com.example.IntensiveContext.IntensiveContext;
import com.example.PracticePackage.AnnotatedClass;
import com.example.PracticePackage.AnnotatedClassWithAnnotatedField;

public class Main {
  public static void main(String[] args) {
    IntensiveContext context = new IntensiveContext("com.example.PracticePackage");
    AnnotatedClass annotatedClass = context.getObject(AnnotatedClass.class);
    annotatedClass.printText();
    AnnotatedClassWithAnnotatedField annotatedClassWithAnnotatedField = context.getObject(
        AnnotatedClassWithAnnotatedField.class);
    annotatedClassWithAnnotatedField.printText();
    annotatedClassWithAnnotatedField.getAnnotatedClassForInjection().printText();
  }
}