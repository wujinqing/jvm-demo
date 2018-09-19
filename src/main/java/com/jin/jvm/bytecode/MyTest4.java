package com.jin.jvm.bytecode;

/*
    栈帧(stack frame)

    栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。

    栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。


    每个线程都有一个独立的栈帧，栈帧是不会出现并发问题的

    符号引用，直接引用

    有些符号引用是在类加载阶段或是第一次使用时就会转换为直接引用，这种转换叫做静态解析；另外一些符号引用则是在每次运行期间
    转换为直接引用，这种转换叫做动态链接，这体现为Java的多态性。

    存放局部变量的最小单位是slot


 */

/*

    1.invokeinterface: 调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的哪个对象的特定方法。
    2.invokestatic: 调用静态方法。
    3.invokespecial: 调用私有方法、构造方法(<init>)以及父类的方法。
    4.invokevirtual: 调用虚方法，运行期动态查找的过程(多态)。
    5.invokedynamic: 动态调用方法。

    能够被invokestatic和invokespecial调用的方法都是能在解析阶段确定的，有四类。
    1.父类的方法、静态方法、私有方法、自己的构造方法。这四种方法在加载阶段就会将符号引用替换为直接引用。
 */

/*
    静态解析的4种情形：

    1.静态方法
    2.父类方法
    3.构造方法
    4.私有方法(无法被重写)

    以上4种方法称作非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用的。
 */
public class MyTest4 {
    public void test()
    {
        int a = 3;

        if(a < 4)
        {
            int b = 4;
            int c = 5;
        }

        int d = 6;
        int e = 7;
        // d和e的可能会复用b和c的slot，与虚拟机实现有关

    }

    public static void test2()
    {
        System.out.println("test2 invoked");
    }

    public static void main(String[] args) {
        test2();
    }

}
