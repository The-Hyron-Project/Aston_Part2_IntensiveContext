package com.example.PracticePackage;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

//Простой аннотированный класс для инъекции в другой класс в пакете PracticePackage
@IntensiveComponent
public class AnnotatedClassForInjection {
  String text;

  public AnnotatedClassForInjection(){}

  public AnnotatedClassForInjection(String text) {
    this.text = text;
  }

  public void printText(){
    System.out.println(text);
  }
}
