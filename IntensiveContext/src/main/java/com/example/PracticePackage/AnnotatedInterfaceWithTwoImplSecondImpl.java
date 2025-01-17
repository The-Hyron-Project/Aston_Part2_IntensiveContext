package com.example.PracticePackage;

//Класс-реализация интерфейса AnnotatedInterfaceWithTwoImpl
// для поиска в пакете PracticePackage (вторая реализация)
public class AnnotatedInterfaceWithTwoImplSecondImpl implements AnnotatedInterfaceWithTwoImpl{

  String text;

  public AnnotatedInterfaceWithTwoImplSecondImpl(){}


  @Override
  public void printText() {
    System.out.println(text);
  }
}
