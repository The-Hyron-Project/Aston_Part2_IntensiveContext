package com.example.PracticePackage;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

@IntensiveComponent
public class AnnotatedClassWithAnnotatedField {
    String text;
    AnnotatedClassForInjection annotatedClassForInjection;

  public AnnotatedClassWithAnnotatedField(){};

    public AnnotatedClassWithAnnotatedField(String text, AnnotatedClassForInjection annotatedClassForInjection) {
      this.text = text;
      this.annotatedClassForInjection= annotatedClassForInjection;
    }

  public AnnotatedClassForInjection getAnnotatedClassForInjection() {
    return annotatedClassForInjection;
  }

  public void printText(){
      System.out.println(text);
    }
}
