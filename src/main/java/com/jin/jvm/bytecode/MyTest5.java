package com.jin.jvm.bytecode;

/*
    方法的静态分派:

    Grandpa g1 = new Father();

    以上代码，g1的静态类型是Grandpa，而g1的实际类型(真正指向的类型)是Father, 静态类型是不会变的，实际类型可能发生变化(多态)。

    强制向下类型转换对g1并没有任何改变，而是将g1类型转换成子类型。

    我看可以得到这样一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的(多态的一种体现)，实际类型是在运行期方可确定。


 */
public class MyTest5 {
    // 方法重载，是一种静态的行为，编译器就可以完全确定，根据变量的静态类型来决定调用哪个方法。

    public void test(Grandpa grandpa)
    {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();

        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
