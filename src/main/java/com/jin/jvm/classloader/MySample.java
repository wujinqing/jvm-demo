package com.jin.jvm.classloader;

public class MySample {
    static {
        System.out.println("MySample static blocked is invoked!");
    }

    public MySample()
    {
        System.out.println("MySample is loaded by :" + this.getClass().getClassLoader());

        new MyCat();
    }
}
