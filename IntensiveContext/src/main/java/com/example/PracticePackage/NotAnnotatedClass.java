package com.example.PracticePackage;

//Простой неаннотированный класс для поиска в пакете PracticePackage
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
