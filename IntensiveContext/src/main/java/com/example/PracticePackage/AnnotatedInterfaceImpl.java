package com.example.PracticePackage;

//Класс-реализация интерфейса AnnotatedInterface для поиска в пакете PracticePackage
public class AnnotatedInterfaceImpl implements AnnotatedInterface{

  public AnnotatedInterfaceImpl(){}

  String text;

  public AnnotatedInterfaceImpl(String text) {
    this.text = text;
  }


  @Override
  public void printText() {
    System.out.println(text);
  }
}
