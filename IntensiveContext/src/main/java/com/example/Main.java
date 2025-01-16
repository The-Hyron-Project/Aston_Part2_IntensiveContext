package com.example;

import com.example.IntensiveContext.Exceptions.InterfaceHasMoreThanOneImplementation;
import com.example.IntensiveContext.IntensiveContext;
import com.example.PracticePackage.AnnotatedClass;
import com.example.PracticePackage.AnnotatedClassWithAnnotatedField;
import com.example.PracticePackage.AnnotatedInterface;
import com.example.PracticePackage.AnnotatedInterfaceWithNoImpl;
import com.example.PracticePackage.AnnotatedInterfaceWithTwoImpl;
import com.example.PracticePackage.NotAnnotatedClass;
import com.example.PracticePackage2.AnnotatedSideClass;

public class Main {
  public static void main(String[] args) {
    IntensiveContext context = new IntensiveContext("com.example.PracticePackage");
    AnnotatedClass annotatedClass = context.getObject(AnnotatedClass.class);
    annotatedClass.printText();
    AnnotatedClassWithAnnotatedField annotatedClassWithAnnotatedField = context.getObject(
        AnnotatedClassWithAnnotatedField.class);
    annotatedClassWithAnnotatedField.printText();
    annotatedClassWithAnnotatedField.getAnnotatedClassForInjection().printText();
    AnnotatedInterface annotatedInterface = context.getObject(AnnotatedInterface.class);
    annotatedInterface.printText();
    AnnotatedInterfaceWithNoImpl annotatedInterfaceWithNo = context.getObject(AnnotatedInterfaceWithNoImpl.class);
    annotatedInterfaceWithNo.printText();
    AnnotatedInterfaceWithTwoImpl annotatedInterfaceWithTwo = context.getObject(AnnotatedInterfaceWithTwoImpl.class);
    annotatedInterfaceWithTwo.printText();
    NotAnnotatedClass notAnnotatedClass = context.getObject(NotAnnotatedClass.class);
    notAnnotatedClass.printText();
    AnnotatedSideClass annotatedSideClass = context.getObject(AnnotatedSideClass.class);
    annotatedSideClass.printText();
  }
}