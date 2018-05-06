package com.jin.jvm.classloader;

import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
//        System.out.println(MyChild5.b);// b 在编译器 已经被纳入到MyTest5常量池中
//        System.out.println(MyChild5.b1);// b1 由于只有在运行期才能确定其值，所以不会纳入到常量池中

        System.out.println(MyParent5_11.thread);
    }
}

/*
  接口中的属性都是public、static, final的， 修饰符可以省略.
  接口本身是没有静态代码块的。

  当一个接口在初始化时， 并不要求其父接口都完成了初始化。
  只有在真正使用到父接口的时候(如引用接口中所定义的常量时)，才会初始化。

  当一个类被初始化的时候它所实现的接口是不会被初始化的

 */
interface MyParent5 {
    public static final int a = 5;

    public static Thread thread = new Thread()
    {
        {
            System.out.println("thread init");
        }
    };
}

interface MyChild5 extends MyParent5 {
    public static final int b = 6;
    public static final int b1 = new Random().nextInt();


}

class C {
    {
        // 每次实例化，这个非静态代码块都会执行一次
        System.out.println("hello");
    }

    public C()
    {
        System.out.println("C");
    }
}


interface MyGrandpa5_1 {
    public static Thread thread = new Thread()
    {
        {
            System.out.println("MyGrandpa5_1 init");
        }
    };
}

interface MyParent5_11 extends MyGrandpa5_1{
    public static Thread thread = new Thread()
    {
        {
            System.out.println("MyParent5_11 init");
        }
    };
}