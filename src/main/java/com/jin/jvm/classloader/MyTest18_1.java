package com.jin.jvm.classloader;

/*
    将MyTest1的Class文件拷贝到启动类加载器加载类的路径：/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/classes目录下
 */
public class MyTest18_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.jin.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("classLoader:" + clazz.getClassLoader());
    }
}
