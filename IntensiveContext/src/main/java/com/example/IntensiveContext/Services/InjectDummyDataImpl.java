package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.InjectDummyData;
import java.lang.reflect.Field;

public class InjectDummyDataImpl implements InjectDummyData {

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
}
