package com.jin.jvm.classloader;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + singleton.counter1);
        System.out.println("counter2:" + singleton.counter2);
    }
}

/*
    初始化是从上到下执行的

    执行打印出来：
    counter1:1
    counter2:1
 */
//class Singleton {
//    public static int counter1;
//
//    public static int counter2 = 0;
//
//    private static Singleton singleton = new Singleton();
//
//    private Singleton()
//    {
//        counter1++;
//        counter2++;
//
//        System.out.println(counter1);
//        System.out.println(counter2);
//    }
//
//    public static Singleton getInstance()
//    {
//        return singleton;
//    }
//}


/*
    初始化是从上到下执行的

    执行打印出来：
    counter1:1
    counter2:0

    准备阶段： 赋jvm给的默认值
    counter1 = 0；
    singleton = null;
    counter2 = 0；// 这个零是默认值

    初始化阶段：赋程序代码给的值
    counter1 = 0；
    singleton = new Singleton();
    counter2 = 0；// 这个零是程序员赋给它的值

 */
class Singleton {
    public static int counter1;// 连接的准备阶段该值被赋为0， counter2也是



    private static Singleton singleton = new Singleton();

    private Singleton()
    {
        counter1++;// counter1 = 1
        counter2++;// counter2 = 1    准备阶段的重要意义 如果没有准备阶段给counter2赋0，那么这样就好有问题

        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;// 初始化阶段被赋值为 0 ，这时counter2 = 0
    public static Singleton getInstance()
    {
        return singleton;
    }
}






















