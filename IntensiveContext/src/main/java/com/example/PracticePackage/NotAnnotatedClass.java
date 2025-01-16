package com.example.PracticePackage;

public class NotAnnotatedClass {
  public NotAnnotatedClass(){}

  String text;

  public NotAnnotatedClass(String text) {
    this.text = text;
  }

  public void printText(){
    System.out.println(text);
  }
}
