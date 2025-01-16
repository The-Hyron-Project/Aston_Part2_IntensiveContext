package com.example.PracticePackage;

public class AnnotatedInterfaceWithTwoImplSecondImpl implements AnnotatedInterfaceWithTwoImpl{

  String text;

  public AnnotatedInterfaceWithTwoImplSecondImpl(){}


  @Override
  public void printText() {
    System.out.println(text);
  }
}
