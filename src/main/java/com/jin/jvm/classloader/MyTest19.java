package com.jin.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/*
java -Djava.ext.dirs=./ com.jin.jvm.classloader.MyTest19 指定扩展类加载器的路径

Exception in thread "main" java.lang.NoClassDefFoundError: com/sun/crypto/provider/AESKeyGenerator
        at com.jin.jvm.classloader.MyTest19.main(MyTest19.java:7)


 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
