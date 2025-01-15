package com.example.IntensiveContext.Interfaces;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface DependencyInjection {
public Object injectObjects(Object obj, ArrayList<Field> listOfFields, String package_name);
<T> T convertObject (Class<T> classType, Object obj);
}
