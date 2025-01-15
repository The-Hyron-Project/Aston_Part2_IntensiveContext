package com.example.PracticePackage;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

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
