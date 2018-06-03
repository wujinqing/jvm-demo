## Class类说明

public static Class<?> forName(String name, boolean initialize,forClassLoader loader)

> 返回与给定名字所关联的类或者接口的Class对象。使用给定的类加载器来去加载，如果给定了类或者接口的完全限定名(即binary name)

> 这个方法会尝试去定位、加载、连接这个类或者接口。指定的类加载器是用来加载这个类或者接口的，如果loader参数为null，

> 那么这个类就会通过启动类加载器来去加载, 这个类只有当initialize设置为true并且这个类之前没有被初始化时才会去初始化它

> (如果它已经被初始化了说明这个类已经完成了加载和连接操作)。


> 如果name表示的是一个原生的数据类型或者是void，它会尝试到默认包去加载它，因此这个方法是不能用于加载原生的数据类型或者void的。

> 如果加载的是一个数组类型，那么component类型会被加载但不会被初始化。

> Class.forName("Foo") 等价于 Class.forName("Foo", true, this.getClass().getClassLoader())



































