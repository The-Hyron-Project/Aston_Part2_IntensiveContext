package com.example;

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
//    Создаём контекст
    IntensiveContext context = new IntensiveContext("com.example.PracticePackage");
//    Запрашиваем объект типа AnnotatedClass.class и вызываем печать текста
//    Должно завершиться успешно
    AnnotatedClass annotatedClass = context.getObject(AnnotatedClass.class);
    annotatedClass.printText();
//    Запрашиваем объект типа AnnotatedClassWithAnnotatedField.class и вызываем печать текста
//    Так же вызываем инжектированный объект AnnotatedClassForInjection() и вызываем у него печать текста
//    Должно завершиться успешно
    AnnotatedClassWithAnnotatedField annotatedClassWithAnnotatedField = context.getObject(AnnotatedClassWithAnnotatedField.class);
    annotatedClassWithAnnotatedField.printText();
    annotatedClassWithAnnotatedField.getAnnotatedClassForInjection().printText();
//    Запрашиваем объект типа AnnotatedInterface.class и вызываем печать текста у объекта имплементации
//    Должно завершиться успешно т.к. у интерфейса только одна реализация
    AnnotatedInterface annotatedInterface = context.getObject(AnnotatedInterface.class);
    annotatedInterface.printText();
//    Запрашиваем объект типа AnnotatedInterfaceWithNoImpl.class и вызываем печать текста у объекта имплементации
//    Должно завершиться неуспешно т.к. у интерфейса нет реализации
    AnnotatedInterfaceWithNoImpl annotatedInterfaceWithNo = context.getObject(AnnotatedInterfaceWithNoImpl.class);
    annotatedInterfaceWithNo.printText();
//    Запрашиваем объект типа AnnotatedInterfaceWithTwoImpl.class и вызываем печать текста у объекта имплементации
//    Должно завершиться неуспешно т.к. у интерфейса две реализации
    AnnotatedInterfaceWithTwoImpl annotatedInterfaceWithTwo = context.getObject(AnnotatedInterfaceWithTwoImpl.class);
    annotatedInterfaceWithTwo.printText();
//    Запрашиваем объект типа NotAnnotatedClass.class и вызываем печать текста
//    Должно завершиться неуспешно т.к. класс не аннотирован
    NotAnnotatedClass notAnnotatedClass = context.getObject(NotAnnotatedClass.class);
    notAnnotatedClass.printText();
//    Запрашиваем объект типа AnnotatedSideClass.class и вызываем печать текста
//    Должно завершиться неуспешно т.к. класс находится в стороннем пакете
    AnnotatedSideClass annotatedSideClass = context.getObject(AnnotatedSideClass.class);
    annotatedSideClass.printText();
  }
}