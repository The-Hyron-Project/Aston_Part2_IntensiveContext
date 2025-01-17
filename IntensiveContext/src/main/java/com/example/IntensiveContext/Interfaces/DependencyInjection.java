package com.example.IntensiveContext.Interfaces;

import java.lang.reflect.Field;
import java.util.ArrayList;

/** Интерфейс, описывающий поведение классов, внедряющих зависимости в другие классы. */
public interface DependencyInjection {
  /** Метод, внедряющий объекты.
   * @param obj - объект, в который нужно внедрить другой объект.
   * @param listOfFields - перечень полей, аннотированных @IntensiveComponent.
   * @param package_name - имя пакета, в котором следует искать нужную зависимость.
   * @return - объект, содержащий все внедрённые зависимости.
   */
public Object injectObjects(Object obj, ArrayList<Field> listOfFields, String package_name);

  /** Метод, приводящий объект типа Object к типу.
   * @param classType - тип, к которому нужно привести объект.
   * @param obj - объект, в который нужно привести к типу.
   * @return - объект, приведённый к типу.
   */
<T> T convertObject (Class<T> classType, Object obj);
}
