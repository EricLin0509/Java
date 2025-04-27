# final

## 定义

在Java中，`final`是一个关键字，用于修饰类、方法和变量。它的作用如下：

- 修饰类 —— 表示该类**不能被继承**，即不能有子类
- 修饰方法 —— 表示该方法**不能被重写**
- 修饰变量 —— 表示该变量的值**不能被修改**


## 语法

### 修饰类
```java
public final class MyClass {
    // ...
}
```

### 修饰方法
```java
public final void myMethod() {
    //...
}
```

### 修饰变量
```java
public final int myVariable = 10;
```

## 代码示例

### 修饰类

用 `final` 修饰类可以防止类被继承

```java
// FinalClass.java

public final class FinalClass {
    int a;
    public FinalClass(int a) {
        this.a = a;
    }
}
```

```java
// SubClass.java

public class SubClass extends FinalClass {
    public SubClass(int a) {
        super(a);
    }
}
```

此时会报错:
```
The type SubClass cannot subclass the final class FinalClass
```

所以 `final` 类一般**用于一些工具类，或者一些不需要被继承的类**

### 修饰方法

用 `final` 修饰方法可以防止方法被重写

```java
// Animal.java

public class Animal {
    public final void speak() {
        System.out.println("Animal speaks");
    }
}
```

```java
// Dog.java

public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}
```

此时会报错:
```
Cannot override the final method from Animal
```

所以 `final` 方法一般用于**确保方法不能被子类重写**

### 修饰变量

用 `final` 修饰变量表示此变量只能初始化一次

```java
final double PI = 3.1415;
PI = 3;
```

此时会报错:
```
The final local variable PI cannot be assigned. It must be blank and not using a compound assignment
```

也可以用于静态变量

```java
public static final int MAX_VALUE = 100;
MAX_VALUE = 200; // 编译错误
```

所以 `final` 变量一般用于**声明常量**

## 总结

`final`关键字可以提高代码的安全性和可维护性，因为它可以防止代码中的错误和漏洞。同时，它还可以提高代码的性能，因为它可以使编译器对代码进行优化