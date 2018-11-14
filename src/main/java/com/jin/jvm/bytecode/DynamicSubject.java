package com.jin.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
    private Subject subject;

    public DynamicSubject(Subject obj)
    {
        subject = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        method.invoke(this.subject, args);
        System.out.println("after invoke");
        return null;
    }
}
