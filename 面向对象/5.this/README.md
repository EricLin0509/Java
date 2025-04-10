# this

## 定义
在Java中，this关键字代表当前对象的引用，它可以用于访问当前对象的属性和方法

它有以下几种用法：

- 指代当前对象
- 在构造方法中调用其他构造方法

**注意：this关键字只能在非静态方法中使用**

## 代码示例

## 指代当前对象

```java
// Dog.java

public class Dog {
    private String name;
    private int age;

    public void setName(String name) {
        name = name;
    }
}
```

但是这样的话，对象中的name属性就没有被赋值，因为参数和属性的名字相同

**那就需要使用this关键字来指代当前对象**

```java
public void setName(String name) {
    this.name = name;
}
```

这样就可以把name这个参数的值赋给name这个属性

```java
//main.java

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("旺财");
        System.out.println(dog.getName());
    }
}
```

```
旺财
```

但是在静态方法中使用this关键字，就会报错

```java
// Dog.java

public class Dog {
    private String name;
    private int age;
    public static void setName(String name) {
        this.name = name;
    }
}
```

这是因为，**静态方法是属于类的，而不是属于对象的**，所以静态方法中不能使用this关键字

## 在构造方法中调用其他构造方法

```java
// Dog.java

public class Dog {
    private String name;
    private int age;

    public Dog() {
        this("旺财", 2);
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

前面的无参构造方法中调用了有参构造方法，使用this关键字来调用构造方法

```java
//main.java

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
```

**注意：**

- **必须在构造方法的第一行调用**
- **构造函数中只允许一次显式构造函数调用**


```java
// Dog.java

public class Dog {
    private String name;
    private int age;
    public Dog() {
        System.out.println("无参构造方法");
        this("旺财", 2);
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
//Dog.java
public class Dog {
    private String name;
    private int age;
    public Dog() {
        this("旺财", 2);
        this();
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

以上两种写法都是错误的