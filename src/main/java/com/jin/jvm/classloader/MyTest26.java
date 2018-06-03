package com.jin.jvm.classloader;

/*
    线程上下文类加载器的一般使用模式(获取 - 使用 - 还原)

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    try {
        Thread.currentThread().setContextClassLoader(targetTccl);
        myMethod();
    }finally {
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器(即我们自己设置的targetTccl)
    做某些事情。

    如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的(如果该依赖类之前没有被加载过的话)。

    ContextClassLoader的作用就是为了破坏Java的类加载委托机制。

    在SPI接口的代码中，使用线程上下文类加载器就可以成功加载到SPI实现的类。

    线程上下文类加载器在很多SPI中都得到了大量的使用。

    当高层提供了统一的接口让低层去实现，同时又要在高层加载(或实例化)低层的类时，就必须要通过线程上下文类加载器来帮助高层的ClassLoader
    找到并加载该类。

    默认的ContextClassLoader设置Launcher类的JVM启动线程里面设置的

    Thread.currentThread().setContextClassLoader(this.loader);


    所有Java代码都是由线程去执行的，把ContextClassLoader放在线程里可以很方便的获取到

    ThreadLocal每个线程都会有数据的一个副本(典型的用空间换取时间)

 */

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest26 {
    public static void main(String[] args) {
        // 改变上下文类加载器为ExtClassLoader, 将加载不到任何资源。
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext())
        {
            Driver driver = iterator.next();

            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());

        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());




















    }
}
