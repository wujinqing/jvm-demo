package com.jin.jvm.classloader;

import java.util.Random;

class FinalTest {
    public static final int x = 3;
//    public static int x = 3;
//    public static final int x = new Random().nextInt();

    // 静态代码块没有被执行，意味着类没有被初始化
    static {
        System.out.println("FinalTest static block.");
    }

}
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
