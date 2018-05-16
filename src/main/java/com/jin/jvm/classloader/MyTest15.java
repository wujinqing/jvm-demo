package com.jin.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];

        System.out.println(strings.getClass().getClassLoader());// 这里输出的null表示启动类加载器

        System.out.println("-----------");

        int[] ints = new int[2];

        System.out.println(ints.getClass().getClassLoader());// 这里输出的null，表示没有类加载器

        System.out.println("--------");

        MyTest15[] myTest15s = new MyTest15[2];

        System.out.println(myTest15s.getClass().getClassLoader());

    }
}
