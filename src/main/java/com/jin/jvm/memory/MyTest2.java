package com.jin.jvm.memory;

/*
    虚拟机栈溢出: StackOverflowError

 */
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test()
    {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.length++;
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        try {
            myTest2.test();
        }catch (Throwable ex)
        {
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }
    }
}
