package com.example.PracticePackage;

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
