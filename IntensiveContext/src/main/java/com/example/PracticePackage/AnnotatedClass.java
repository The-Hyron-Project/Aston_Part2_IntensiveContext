package com.example.PracticePackage;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

//Простой аннотированный класс для поиска в пакете PracticePackage
@IntensiveComponent
public class AnnotatedClass {

  public AnnotatedClass(){}

  String text;

  public AnnotatedClass(String text) {
    this.text = text;
  }

  public void printText(){
    System.out.println(text);
  }
}
