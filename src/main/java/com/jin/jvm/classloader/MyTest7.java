package com.jin.jvm.classloader;

/*
getClassLoader（）: 返回加载这个类的类加载器，或者null

返回null：
1.bootstrap类加载器加载的类。
2.原始类型或者void
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.jin.jvm.classloader.C2");

        System.out.println(clazz2.getClassLoader());
    }
}

class C2 {

}