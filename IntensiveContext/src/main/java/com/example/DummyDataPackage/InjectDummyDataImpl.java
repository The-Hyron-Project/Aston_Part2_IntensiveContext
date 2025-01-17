package com.example.DummyDataPackage;

import com.example.IntensiveContext.Services.AnnotationSearchImpl;
import java.lang.reflect.Field;

public class InjectDummyDataImpl implements InjectDummyData {
  private static InjectDummyDataImpl INSTANCE;

  private InjectDummyDataImpl(){};

  @Override
  public Object injectDummyText(Object obj, String text) {
    try {
      Field field = obj.getClass().getDeclaredField("text");
      field.setAccessible(true);
      field.set(obj, text);
    } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return obj;
  }

  public static InjectDummyDataImpl getInstance(){
    if(INSTANCE==null){
      INSTANCE = new InjectDummyDataImpl();
    }
    return INSTANCE;
  }
}
