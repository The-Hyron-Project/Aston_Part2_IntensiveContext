package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Interfaces.SearchInterface;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class SearchService implements SearchInterface {

  String[] classPathStr = System.getProperty("java.class.path").split(":");
  GetClassImpl getClass = new GetClassImpl();
  AnnotationSearchImpl annotationSearch = new AnnotationSearchImpl();

  @Override
  public Class<?> findClass(String package_name, Class<?> classType) {
    ArrayList<Class<?>> classes = new ArrayList<>();
    for(int i = 0; i<classPathStr.length;i++){
      File file = new File(classPathStr[i]+"/"+(package_name.replace(".","/")));
      if(file.exists()){
        try (Stream<Path> paths = Files.walk(Paths.get(file.toURI()))) {
          paths.forEach(files -> {
            if (files.getFileName().toString().equals(classType.getSimpleName()+".class")) {
              Class<?> clazz = getClass.createClass(package_name +"."+ classType.getSimpleName());
              if(clazz!=null && annotationSearch.isClassAnnotated(clazz)){
                classes.add(clazz);
                annotationSearch.areFieldsAnnotated(clazz);
              }
            }
          });
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return classes.getFirst();
  }
}
