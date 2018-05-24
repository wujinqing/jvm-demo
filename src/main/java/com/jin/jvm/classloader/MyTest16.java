package com.jin.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader
{
    private String classLoaderName;
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

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked");



        byte[] data = loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name)
    {


        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            this.classLoaderName = this.classLoaderName.replace(".", "/");
            name = name.replace(".", "/");
            name = "/workspace/jvm-demo/out/production/classes/" + name;

            is = new FileInputStream(new File(name + fileExtention));

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
        Class<?> clazz = classLoader.loadClass("com.jin.jvm.classloader.MyTest1");

        Object object = clazz.newInstance();
        System.out.println(object.getClass().getClassLoader());
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        MyTest16 myTest16 = new MyTest16(null, "loader1");

        test(myTest16);
    }
}
