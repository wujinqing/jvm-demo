package com.jin.jvm.example;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.reflect.TypeVariable;

/**
 * @author wu.jinqing
 * @date 2018年05月24日
 */
public class MyClass<T> {
    private String str = "aaa";
    private int a = 1;

    public static void main(String[] args) {
        Class<?> clazz = MyClass.class;

        System.out.println(clazz.getPackage().getName());
        System.out.println(clazz.getPackage().getSpecificationTitle());
        System.out.println(clazz.getPackage().getSpecificationVersion());
        System.out.println(clazz.getPackage().getSpecificationVendor());
        System.out.println(clazz.getPackage().getImplementationTitle());
        System.out.println(clazz.getPackage().getImplementationVersion());
        System.out.println(clazz.getPackage().getImplementationVendor());
        System.out.println(clazz.getPackage().isSealed());
        System.out.println(Package.getPackage("java.lang"));

        System.out.println("---------------------");


        System.out.println(clazz.toGenericString());
        System.out.println(clazz.toString());
        System.out.println(clazz.getName());
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();

        System.out.println(typeVariables.length);

        for(TypeVariable t : typeVariables)
        {
            System.out.println(t.getName());
        }

        System.out.println(clazz.getDeclaringClass());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
//        System.out.println(clazz.getSimpleBinaryName());

    }
}
