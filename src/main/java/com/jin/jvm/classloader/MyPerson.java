package com.jin.jvm.classloader;

public class MyPerson {
    private MyPerson myPerson;
    public void setMyPerson(Object object)
    {
        System.out.println("setMyPerson invoked!");
        myPerson = (MyPerson)object;
    }
}
