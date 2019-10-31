package com.jin.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/*
    方法区产生内存溢出错误:

    1.元空间默认大小是21M.
    2.可以自动扩容。
    3.元空间是一个与堆内存不相连的本地内存区域。


 */
public class MyTest4 {
    public static void main(String[] args) {
        for (;;) {
            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, arg1, proxy) ->
                    proxy.invoke(obj, arg1));

            System.out.println("hello world.");

            enhancer.create();
        }
    }
}
