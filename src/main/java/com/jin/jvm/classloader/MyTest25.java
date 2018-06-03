package com.jin.jvm.classloader;

public class MyTest25 implements Runnable{
    private Thread thread;

    public MyTest25()
    {
        this.thread = new Thread(this);
        this.thread.start();
    }
    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader);
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
