package com.example.IntensiveContext;

import com.example.IntensiveContext.Exceptions.NoSuchClassException;
import com.example.IntensiveContext.Services.AnnotationSearchImpl;
import com.example.IntensiveContext.Services.CreateObjectImpl;
import com.example.IntensiveContext.Services.DependencyInjectionImpl;
import com.example.DummyDataPackage.InjectDummyDataImpl;
import com.example.IntensiveContext.Services.SearchService;
import java.util.HashMap;

/**
 * Проект Мини-Spring для интенсива Java Aston.
 * Класс IntensiveContext.
 * @autor Булатов Илья, поток 94.
 * @version 1.0
 */
public class IntensiveContext {

  /** Хешмап для хранения созданных объектов,
   *  ключ - тип объекта, значение - объект типа, хранимого в ключе. */
  private HashMap<Class<?>, Object> contextMap = new HashMap<>();
  /** Поле хранения названия пакета. */
  String package_name;
  /** Поле хранения сервиса поиска. */
  SearchService searchService;
  /** Поле хранения сервиса создания объектов. */
  CreateObjectImpl createObject;
  /** Поле хранения сервиса поиска аннотаций. */
  AnnotationSearchImpl annotationSearch;
  /** Поле хранения сервиса внедрения зависимостей. */
  DependencyInjectionImpl dependencyInjection;
  /** Поле хранения сервиса внедрения тестовых данных. */
  InjectDummyDataImpl injectDummyData;

  /**
   * Конструктор, принимающий на вход имя пакета в виде String.
   * @param package_name - имя макета, в котором должен проводиться поиск.
   * Так же конструктор запрашивает объекты требуемых сервисов.
   */
  public IntensiveContext(String package_name) {
    this.package_name = package_name;
    searchService = SearchService.getInstance();
    createObject = CreateObjectImpl.getInstance();
    annotationSearch = AnnotationSearchImpl.getInstance();
    dependencyInjection = DependencyInjectionImpl.getInstance();
    injectDummyData = InjectDummyDataImpl.getInstance();
  }

  /** Метод, возвращающий объект переданного класса.
   * @param classType - класс, объект которого требуется вернуть.
   * @return - объект типа T
   * Если объект пуст, то выбрасывается ошибка NoSuchClassException.
   */
  public <T> T getObject (Class<T> classType) {
    if(contextMap.containsKey(classType)){
      return (T) contextMap.get(classType);
    }
    Class<?> clazz = searchService.findClass(package_name, classType);
    Object obj = createObject.createObject(clazz);
    obj = injectDummyData.injectDummyText(obj, "Класс " + clazz.getSimpleName() + " загружен из файла");
    if(obj!=null){
      if(annotationSearch.areFieldsAnnotated(clazz)){
        obj = dependencyInjection.injectObjects(obj, annotationSearch.getAnnotatedFields(clazz), package_name);
      }
      contextMap.put(classType, obj);
      return (T) obj;
    }else{
      throw new NoSuchClassException("Class " + classType + " not found in the " + package_name + " package.");
    }
  }
}
