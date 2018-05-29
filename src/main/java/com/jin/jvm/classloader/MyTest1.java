package com.jin.jvm.classloader;

/*
    对于静态字段来说，只有直接定义了该字段的类才会被初始化；
    当一个类在初始化时，要求其父类全部都已经初始化完毕了(父类还有父类 都要先初始化)
    -XX:+TrackClassLoading 按类的加载顺序输出程序所加载的类，用于追踪类的加载信息并打印出来
    -XX:+TraceClassUnloading 类卸载消息

    JVM参数都是以【-XX:】开头的 后面跟一个+或者-，+表示开启，-表示关闭，
    为什么会有+或者-呢？因为有些JVM参数默认是开启的有些默认是关闭的

    在VM的参数设置中一共只有三种设置方式：
    -XX:+<option>, 表示开启option选项
    -XX:-<option>, 表示关闭option选项
    -XX:<option>=<value>, 表示将option选项的值设置成value. 典型的如调整堆空间大小

 */
public class MyTest1 {
    /*

        执行 System.out.println(MyChild1.str);  按顺序加载MyTest1、MyParent1、MyChild1类
     */
    public static void main(String[] args) {
        System.out.println(MyChild1.str);// 静态字段str定义在父类里面，子类不会被初始化
//        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";

    // 静态代码块是在初始化的时候执行的
    static {
        System.out.println("MyParent1 static block");

    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");

    }
}
