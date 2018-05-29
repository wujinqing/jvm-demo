package com.jin.jvm.classloader;

public class MyCat {
    static
    {
        System.out.println("MyCat static block invoked!");
    }

    public MyCat()
    {
        System.out.println("MyCat is loaded by :" + this.getClass().getClassLoader());
        System.out.println("form MyCat: " + MySample.class);
    }
}
