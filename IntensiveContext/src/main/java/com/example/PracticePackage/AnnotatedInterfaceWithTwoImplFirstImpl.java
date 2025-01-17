package com.example.PracticePackage;

//Класс-реализация интерфейса AnnotatedInterfaceWithTwoImpl
// для поиска в пакете PracticePackage (первая реализация)
public class AnnotatedInterfaceWithTwoImplFirstImpl implements AnnotatedInterfaceWithTwoImpl {

  String text;


  public AnnotatedInterfaceWithTwoImplFirstImpl(){}


  @Override
  public void printText() {
    System.out.println(text);
  }
}
