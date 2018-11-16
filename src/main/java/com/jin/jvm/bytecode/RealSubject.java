package com.jin.jvm.bytecode;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from real sub.");
    }

    @Override
    public String toString() {
        System.out.println("to string");
        return "hello to s";
    }
}
