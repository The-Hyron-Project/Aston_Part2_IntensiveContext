package com.example.PracticePackage2;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

//Тестовый класс для поиска несуществующего класса в пакете
@IntensiveComponent
public class AnnotatedSideClass {

  public AnnotatedSideClass(){}

  String text;

  public AnnotatedSideClass(String text) {
    this.text = text;
  }

  public void printText(){
    System.out.println(text);
  }
}
