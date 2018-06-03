package com.jin.jvm.classloader;

/*
    扩展类加载器必须加载jar包，不能直接加载Class文件

> java -Djava.ext.dirs=./ com.jin.jvm.classloader.MyTest22
MyTest22 initializer
sun.misc.Launcher$AppClassLoader@c387f44
sun.misc.Launcher$AppClassLoader@c387f44


打jar包:
将MyTest1.class打入test.jar
jar cvf test.jar com/jin/jvm/classloader/MyTest1.class

将当前目录及子目录下的的所有文件打入jvm.jar
jar cvf jvm.jar .

 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) throws Exception{
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
