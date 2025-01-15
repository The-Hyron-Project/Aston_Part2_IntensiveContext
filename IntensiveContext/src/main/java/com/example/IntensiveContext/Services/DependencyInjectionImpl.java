package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.DependencyInjection;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DependencyInjectionImpl implements DependencyInjection {
  SearchService searchService = new SearchService();
  CreateObjectImpl createObject = new CreateObjectImpl();
  InjectDummyDataImpl injectDummyData = new InjectDummyDataImpl();


  @Override
  public Object injectObjects(Object obj, ArrayList<Field> listOfFields, String package_name) {
  for(int i = 0;i<listOfFields.size();i++){
    Class<?> clazz = searchService.findClass(package_name, (listOfFields.get(i).getType()));
    Object objLocal = createObject.createObject(clazz);
    objLocal = injectDummyData.injectDummyText(objLocal, "Класс " + clazz.getSimpleName() + " введён через инъекцию");
    try {
      Field[] localField = obj.getClass().getDeclaredFields();
      for(int o =0; o<localField.length;o++){
            Field field = listOfFields.get(i);
            field.setAccessible(true);
            field.set(obj, objLocal);
      }
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
    return obj;
  }

  @Override
  public  <T> T convertObject (Class<T> classType, Object obj) {
    return (T) obj;
  }
}
