## 深入理解JVM

### 监控工具

1. jconsole
2. jvisualvm（比jconsole更强大）
3. jmap

### 打jar包

将MyTest1.class打入test.jar
> jar cvf test.jar com/jin/jvm/classloader/MyTest1.class

将当前目录及子目录下的的所有文件打入jvm.jar
> jar cvf jvm.jar .