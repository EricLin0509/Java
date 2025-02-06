# 方法重载

## 定义

方法重载是指在一个类中定义多个同名的方法，但这些方法的参数列表不同，让编译器根据方法的签名自动绑定调用对应的方法

## 代码示例

实现两个或三个数相加的方法

```java
public static void main(String[] args) {
    System.out.println(add(1, 2));
    System.out.println(add(1, 2, 3));
}

public static double add(double a, double b) {
    return a + b;
}

public static double add(double a, double b, double c) {
    return a + b + c;
}
```

[源代码](overloaded.java)

### 运行结果

```bash
3.0
6.0
```