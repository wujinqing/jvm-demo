package com.jin.jvm.memory;

/*
    jcmd (从JDK 1.7开始增加的命令)

    1.jcmd pid VM.flags: 查看JVM的启动参数
    2.jcmd pid help: 列出当前运行的Java进程可以执行的操作
    3.jcmd pid help VM.flags: 查看具体命令的选项
    4.jcmd pid PerfCounter.print: 查看JVM性能相关的参数
    5.jcmd pid VM.uptime: 查看JVM的启动时长
    6.jcmd pid GC.class_histogram: 查看系统中类的统计信息
    7.jcmd pid Thread.print: 查看线程的堆栈信息
    8.jcmd pid GC.heap_dump filename:导出Heap dump文件，导出的文件可以通过jvisual vm查看
    9.jcmd pid VM.system_properties: 查看JVM的属性信息


    jstack: 可以查看或者导出Java应用程序中线程的堆栈信息

    jstack pid

    jmc: Java Mission Control
    jfr: java flight recorder
 */
public class MyTest5 {
    public static void main(String[] args) {
        for (;;)
        {
            System.out.println("hello world.");
        }
    }
}
