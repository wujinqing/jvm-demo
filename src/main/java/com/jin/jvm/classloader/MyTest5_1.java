package com.jin.jvm.classloader;

import java.util.Random;

public class MyTest5_1 {
    public static void main(String[] args) {
        System.out.println(MyChild5_2.c);
    }
}

interface MyParent5_1 {
    public static final MyInner5_1 a = new MyInner5_1();
}

class MyInner5_1
{
    static {
        System.out.println("MyInner5_1 被初始化");
    }
}

class MyChild5_1 implements MyParent5_1
{
    public static final int b = new Random().nextInt(100);
}

interface MyChild5_2 extends MyParent5_1
{
    public static final int c = new Random().nextInt(100);
}
