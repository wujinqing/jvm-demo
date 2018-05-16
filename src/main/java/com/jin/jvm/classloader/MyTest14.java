package com.jin.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.EnumSet;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);

        String resourceName = "com/jin/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements())
        {
            URL url = urls.nextElement();

            System.out.println(url);
        }

        Class<?> clazz = MyTest14.class;

        System.out.println(clazz.getClassLoader());

        clazz = String.class;

        System.out.println(clazz.getClassLoader());


        System.out.println("-----------");
        String[] ss = new String[1];

        System.out.println(ss.getClass().getClassLoader());

        System.out.println("-----------");
        MyTest14[] ss2 = new MyTest14[1];

        System.out.println(ss2.getClass().getClassLoader());

        System.out.println("-----------");
        int[] ss3 = new int[1];

        System.out.println(ss3.getClass().getClassLoader());

    }
}
