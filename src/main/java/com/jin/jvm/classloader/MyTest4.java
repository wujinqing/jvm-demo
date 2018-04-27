package com.jin.jvm.classloader;

/*
    静态代码块只会被执行一次， 首次主动使用才会被初始化， 静态代码块是在初始化的时候执行的。

    对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.jin.jvm.classloader.MyParent4
    这种形式。动态生成的类型，其父类型就是Object。

    对于数组来说，Javadoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型。
    如一维数组MyParent4[]， 它的Component就是MyParent4。
    二维数组MyParent4[][]，它的Component就是[Lcom.jin.jvm.classloader.MyParent4

    数组类型的父类型都是Object

    助记符：
    anewarray：表示创建一个引用类型的(如类，接口，数组)数组，并将其引用值压入栈顶。
    newarray: 表示创建一个指定的原始类型(如int, float, char等)的数组，并将其压入栈顶。
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("=====");
//        MyParent4 myParent5 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];

        // [Lcom.jin.jvm.classloader.MyParent4 这个类型是Java虚拟机在运行期帮我们生成出来的
        System.out.println(myParent4s.getClass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];

        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());


        System.out.println("===========");

        int[] ints = new int[1];// 原生数据类型

        System.out.println(ints.getClass().getSuperclass());
        System.out.println(ints.getClass());// class [I 即：class [java.lang.Integer




        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        long[] longs = new long[1];// class [J
        System.out.println(longs.getClass());

        boolean[] booleans = new boolean[1];// class [Z
        System.out.println(booleans.getClass());

        float[] floats = new float[1];
        System.out.println(floats.getClass());

        double[] doubles = new double[1];
        System.out.println(doubles.getClass());

        char[] chars = new char[1];

        System.out.println(chars.getClass());














    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
