package com.example.PracticePackage;

import com.example.IntensiveContext.Annotations.IntensiveComponent;

//Аннотированный интерфейс с двумя реализациями для поиска реализаций в пакете PracticePackage
@IntensiveComponent
public interface AnnotatedInterfaceWithTwoImpl {
  void printText();
}
