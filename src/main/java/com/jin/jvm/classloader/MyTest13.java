package com.jin.jvm.classloader;

/*

sun.misc.Launcher$AppClassLoader@14dad5dc 系统类加载器或者应用类加载器
sun.misc.Launcher$ExtClassLoader@4b1210ee 扩展类加载器
null 启动类加载器

 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);


        while (null != classLoader)
        {
            // java doc 里面说明了有些实现将getParent返回为null来代表启动类加载器
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
