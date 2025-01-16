package com.example.IntensiveContext.Interfaces;

public interface SearchInterface {
  Class<?> findClass(String package_name, Class<?> classType);
  public Class<?> findInterfaceImplementingClass(String package_name, Class<?> classType);
}
