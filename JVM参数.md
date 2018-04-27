## JVM参数

> JVM参数都是以【-XX:】开头的 后面跟一个+或者-，+表示开启，-表示关闭，

> 为什么会有+或者-呢？因为有些JVM参数默认是开启的有些默认是关闭的

> 在VM的参数设置中一共只有三种设置方式：

> -XX:+\<option>, 表示开启option选项, boolean值类型参数

> -XX:-\<option>, 表示关闭option选项

> -XX:\<option>=\<value>, 表示将option选项的值设置成value. 典型的如调整堆空间大小

### -XX:+TrackClassLoading
> 按类的加载顺序输出程序所加载的类，用于追踪类的加载信息并打印出来.

### -XX:+TraceClassUnloading
> 输出类的卸载信息.




















