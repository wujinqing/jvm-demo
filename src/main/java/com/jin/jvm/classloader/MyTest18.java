package com.jin.jvm.classloader;

public class MyTest18 {
    public static void main(String[] args) {
        // 启动类加载器加载类的目录
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 扩展类加载器加载类的目录
        System.out.println(System.getProperty("java.ext.dirs"));
        // 系统(应用)类加载器加载类的目录
        System.out.println(System.getProperty("java.class.path"));
    }
}
