package com.jin.jvm.classloader;

class CL {
    static {
        System.out.println("class CL");
    }
}

/*
    调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化

    classLoader.loadClass("com.jin.jvm.classloader.CL");// 不是主动使用
    Class.forName("com.jin.jvm.classloader.CL");// 主动使用
 */
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = classLoader.loadClass("com.jin.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("-----------");
        clazz = Class.forName("com.jin.jvm.classloader.CL");

        System.out.println(clazz);
    }
}
