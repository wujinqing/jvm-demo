package com.jin.jvm.classloader;

class Parent3 {
    static int a = 3;

    static
    {
        System.out.println("Parent3 static block");
    }

    static void doSomething()
    {
        System.out.println("do something");
    }
}

class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}

/*
    如果我用子类去访问父类的无论是静态变量也好、静态方法也好，
    本质上都表示对父类的主动使用，而并不是对子类的主动使用，
    变量定义在谁身上就表示对谁的主动使用，并不看调用方
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);// 静态变量定义在哪就表示对谁的主动使用，这里是定义在Parent3里面的，这里并不是对Child3的主动使用

        Child3.doSomething();
    }
}
