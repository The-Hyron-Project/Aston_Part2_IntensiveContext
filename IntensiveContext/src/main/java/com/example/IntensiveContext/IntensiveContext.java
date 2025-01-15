package com.example.IntensiveContext;

import com.example.IntensiveContext.Exceptions.NoSuchClassException;
import com.example.IntensiveContext.Services.AnnotationSearchImpl;
import com.example.IntensiveContext.Services.CreateObjectImpl;
import com.example.IntensiveContext.Services.DependencyInjectionImpl;
import com.example.IntensiveContext.Services.InjectDummyDataImpl;
import com.example.IntensiveContext.Services.SearchService;
import java.util.HashMap;

public class IntensiveContext {

  private HashMap<Class<?>, Object> contextMap = new HashMap<>();
  String package_name;
  SearchService searchService = new SearchService();
  CreateObjectImpl createObject = new CreateObjectImpl();
  AnnotationSearchImpl annotationSearch = new AnnotationSearchImpl();
  DependencyInjectionImpl dependencyInjection = new DependencyInjectionImpl();
  InjectDummyDataImpl injectDummyData = new InjectDummyDataImpl();

  public IntensiveContext(String package_name) {
    this.package_name = package_name;
  }

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
