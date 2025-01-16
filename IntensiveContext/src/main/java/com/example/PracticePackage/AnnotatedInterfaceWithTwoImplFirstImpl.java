package com.example.PracticePackage;

public class AnnotatedInterfaceWithTwoImplFirstImpl implements AnnotatedInterfaceWithTwoImpl {

  String text;


  public AnnotatedInterfaceWithTwoImplFirstImpl(){}


  @Override
  public void printText() {
    System.out.println(text);
  }
}
