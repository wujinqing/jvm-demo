## ClassLoader

> 一个类加载器是一个对象，这个对象它用于负责加载类。类ClassLoader是一个抽象类。

> 给定了一个类的二进制名字，那么类加载器应该尝试**定位**或者**生成**构成类定义的数据，

> 一个典型的策略是将给定的类的二进制名字转换成一个文件名字，然后从文件系统中去读取它所包含的class文件。

> 每一个Class对象都会包含定义这个Class对象的ClassLoader的引用(这也是为什么会有这个方法的原因Class.getClassLoader())。

> 针对于数组类的Class对象并不是由类加载器来创建的，它是由Java虚拟机根据需要自动创建的，对于一个数组类的类加载器来说，

> 通过调用数组对象的getClassLoader()所返回的类加载器和数组元素的类加载器是一样的。

> 如果数组元素类型是一个原生数据类型，那么对于的Class对象没有类加载器，返回null.

> 我们的应用实现类加载器的子类是为了扩展Java虚拟机动态加载类的行为类。


> 类加载器典型情况下是可以被安全管理器所使用，来去标识一些安全域问题。

> ClassLoader类使用了一种委托模型，来去寻找类和资源。ClassLoader的每一个实例都会有一个与之关联的父ClassLoader。

> 当被要求去寻找一个类或者资源时，ClassLoader实例就会在它自己寻找类和资源之前将寻找一个类或者资源的任务委托给它的父ClassLoader。

> 虚拟机内建的ClassLoader我们称之为启动类加载器(bootstrap class loader),启动类加载器本身是没有双亲的(因为它是最顶层的ClassLoader)，

> 但是它可以作为其他类加载器的双亲。

> 支持并发的类加载器就叫做并发行类加载器，它被要求在类的初始化期间通过调用ClassLoader.registerAsParallelCapable方法将其注册上，

> ClassLoader默认情况下就已经被注册为并行的。然而如果子类也需要并行还需要将子类注册。

> 在委托模型并不是严格层次化的环境下，类加载器是需要做到并行的，否则类加载就可能会发生死锁，因为类加载器在加载类期间是要持有锁的。

> 通常情况下，Java虚拟机是以一种平台相关的方式来从文件系统中加载相关的类。例如，在UNIX系统中会从CLASSPATH环境变量所定义的目录下去加载类。

> 然而，一些类并不是来自于文件，可能是从其他来源得到的，比如说，通过网络，或者是由应用本身构建出来的(如动态代理)。

> 方法defineClass会将字节数组转换成Class的实例，新定义的实例可以通过Class.newInstance来创建。



### 二进制名(binary name)

> 以字符串参数向ClassLoader提供的类的名字必须是一个类的名字。

> 有效的类名：

* "java.lang.String"
*   "javax.swing.JSpinner$DefaultEditor"
*   "java.security.KeyStore$Builder$FileBuilder$1"
*   "java.net.URLClassLoader$3$1"

### 定位

> 像String已经存在的

### 生成

> 像动态代理动态生成的类