package com.jin.jvm.classloader;

class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

/**
  主动使用第6中，MyTest9会被初始化
 */
public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
//        System.out.println(Child.b);
        System.out.println(Child.a);
    }
}
