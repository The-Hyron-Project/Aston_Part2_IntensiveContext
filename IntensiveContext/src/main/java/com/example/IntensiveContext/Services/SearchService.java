package com.example.IntensiveContext.Services;

import com.example.IntensiveContext.Exceptions.InterfaceHasMoreThanOneImplementation;
import com.example.IntensiveContext.Exceptions.InterfaceHasNoImplementationException;
import com.example.IntensiveContext.Exceptions.NoSuchClassException;
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
              if(clazz.isInterface() && annotationSearch.isClassAnnotated(clazz)){
                clazz = findInterfaceImplementingClass(package_name, clazz);
                classes.add(clazz);
              }else if(annotationSearch.isClassAnnotated(clazz)){
                classes.add(clazz);
              }
            }
          });
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    if(classes.size()==1){
      return classes.getFirst();
    }else{
      throw new NoSuchClassException("The "+ classType + " is not found or doesn't have the @IntensiveComponent annotation.");
    }
  }

  @Override
  public Class<?> findInterfaceImplementingClass(String package_name, Class<?> interfaceType) {
    ArrayList<Class<?>> implementingClasses = new ArrayList<>();
    for(int i = 0; i<classPathStr.length;i++){
      File file = new File(classPathStr[i]+"/"+(package_name.replace(".","/")));
      if(file.exists()){
        try (Stream<Path> paths = Files.walk(Paths.get(file.toURI()))) {
          paths.forEach(files -> {
            if (files.getFileName().toString().endsWith(".class")) {
              Class<?> clazz = getClass.createClass(package_name +"."+ files.getFileName().toString().replace(".class",""));
              Class<?>[] interfaces = clazz.getInterfaces();
              for(int z = 0; z<interfaces.length;z++){
                if(clazz!=null && interfaces[z].getName().equals(interfaceType.getName())){
                  implementingClasses.add(clazz);
                }
              }
            }
          });
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    if(implementingClasses.size()==1){
      return implementingClasses.getFirst();
    }else if(implementingClasses.isEmpty()){
      throw new InterfaceHasNoImplementationException("The " + interfaceType + " has no methods that implement it.");
    }else{
      throw new InterfaceHasMoreThanOneImplementation("The "+ interfaceType + " has more that one method that implement it.");
    }
  }
}
