package com.jin.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

/*
    当一个类或者一个资源文件存在于多个jar中，就会出现jar hell问题。

    可以通过一些代码来诊断问题。
 */
public class JarHell {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "java/lang/String.class";

//        Class.forName(resourceName);

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements())
        {
            URL url = urls.nextElement();

            System.out.println(url);
        }
    }
}
