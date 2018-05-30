package com.jin.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader
{
    private String classLoaderName;
    private String path; //Class文件所在位置的绝对路径
    private static final String fileExtention = ".class";

    public MyTest16 (String classLoaderName)
    {
        super();// 默认将系统类加载器作为该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName)
    {
        super(parent); // 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    /**
     * 为了让MyTest16成为系统类加载器，必须给这个构造方法
     * @param parent
     */
    public MyTest16(ClassLoader parent) {
        super(parent);
    }



    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);

        byte[] data = loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name)
    {


        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            name = name.replace(".", "/");

            is = new FileInputStream(new File(this.path +name + fileExtention));

            int ch = 0;

            while (-1 != (ch = is.read()))
            {
                baos.write(ch);
            }

            data = baos.toByteArray();

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return data;
    }

    private static void test(ClassLoader classLoader) throws Exception
    {
        // 系统类加载器是MyTest1类的定义类加载器，而系统类加载器和MyTest16是MyTest1类的初始类加载器
        Class<?> clazz = classLoader.loadClass("com.jin.jvm.classloader.MyTest1");

        Object object = clazz.newInstance();
        System.out.println(object.getClass().getClassLoader());
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1  = new MyTest16("loader1");

        loader1.setPath("/Users/wujinqing/Desktop/");

        // comand + w：不断选中快捷键
        Class<?> clazz = loader1.loadClass("com.jin.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();

        System.out.println(object.getClass().getClassLoader());
        System.out.println(object);



        loader1 = null;
        clazz = null;
        object = null;

        // -XX:+TraceClassUnloading 模拟类的卸载
        // [Unloading class com.jin.jvm.classloader.MyTest1 0x00000007c0061028]
        System.gc();

        Thread.sleep(100000);

//        MyTest16 loader2 = new MyTest16("loader2");
//
//        loader2.setPath("/Users/wujinqing/Desktop/");
//
//        // 类加载器的命名空间不同
//        Class<?> clazz2 = loader2.loadClass("com.jin.jvm.classloader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2.getClass().getClassLoader());
//        System.out.println(object2);


        // 同一个类的两个类加载器实例可以成为父子关系(因为类加载器是包含关系)
//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//
//        loader2.setPath("/Users/wujinqing/Desktop/");
//
//        // 类加载器的命名空间不同
//        Class<?> clazz2 = loader2.loadClass("com.jin.jvm.classloader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2.getClass().getClassLoader());
//        System.out.println(object2);
//
//
//        MyTest16 loader3 = new MyTest16(loader2,"loader2");
//
//        loader3.setPath("/Users/wujinqing/Desktop/");
//
//        // 类加载器的命名空间不同
//        Class<?> clazz3 = loader3.loadClass("com.jin.jvm.classloader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3.getClass().getClassLoader());
//        System.out.println(object3);
    }
}
