package com.jin.jvm.classloader;

public class MySample {
    static {
        System.out.println("MySample static blocked is invoked!");
    }

    public MySample()
    {
        System.out.println("MySample is loaded by :" + this.getClass().getClassLoader());

        // 它是由加载MySample类加载器来去尝试加载MyCat类
        new MyCat();
    }
}
