# 方法

方法是一个代码块，当它被调用时，它才会执行

## 语法

### 方法声明

```java
返回值 方法名(参数列表) {
    执行语句
}
```

### 代码示例

编写一个简单的方法

```java
public static void main(String[] args) {
    // 调用方法
    sayHello();
}
// 定义方法
static void sayHello() {
    System.out.println("Hello World!");
}
```

## 参数

参数是在方法被调用时传递给方法的值

### 代码示例

传递一个名字给方法

```java
public static void main(String[] args) {
    // 调用方法
    sayHello("James");
}
// 定义方法
static void sayHello(String name) {
    System.out.println("Hello " + name + "!");
}
```

## 返回值

返回值是方法在执行完后返回给调用它的代码的值

### 代码示例

返回一个数的平方

```java
public static void main(String[] args) {
    // 调用方法
    double result = square(5);
    System.out.println(result);
}
// 定义方法
static double square(double number) {
    return number * number;
}
```

[源代码](method.java)
