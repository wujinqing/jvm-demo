package com.jin.jvm.bytecode;

/*
    方法的动态分派：

    方法的动态分派涉及到一个重要概念: 方法接收者(所谓方法接收者就是这个方法是由谁来调用的)。

    invokevirtual字节码指令的多态查找流程

    invokevirtual查找流程：

    1.首先到操作数栈的栈顶去寻找到栈顶的这个元素所指向的对象的实际类型。
    2.如果在这个类型当中寻找到了与常量池当中的这个描述符和名称都相同的方法并且也具备相应的访问权限，那么就直接返回目标方法的直接引用。

    根据继承体系(从下往上)从子类到父类不停的往上找，直到找到为止。

    比较方法重载(overload)与方法重写(overwrite)，我们可以得到这样的结论：
    方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。


 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test()
    {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}


