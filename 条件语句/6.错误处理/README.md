# 错误处理

## 定义

错误处理是指在程序运行过程中出现异常情况时，程序能够自动处理这些异常情况，以保证程序的稳定性和可靠性

## 语法

在Java中，错误处理主要通过 `try{}`、`catch{}`、`finally{}` 三个关键字来实现

- `try{}` 块用于包含可能出现异常的代码
- `catch{}` 块用于捕获并处理异常
- `finally{}` 块用于在任何情况下都要执行的代码

### 格式

```java
try {
    可能出现异常的代码
}

catch (异常类型1 异常的变量名1) {
    处理异常的代码
}
...


finally { // 可选
    无论是否出现异常，都要执行的代码
}
```

## 代码实现

### 异常代码

这里以除以0的异常为例

```java
public class EHandle {
    public static void main(String[] args) {
        System.out.println(1 / 0);
    }
}
```

直接运行会出现异常

```bash
EHandle in thread "main" java.lang.ArithmeticException: / by zero
	at EHandle.main(EHandle.java:6)
```

### 使用 `try{}`、`catch{}` 处理异常

由于之前报错为 `ArithmeticException`，所以这里需要使用 `catch (ArithmeticException e)` 来捕获异常

```java
public class EHandle {
    public static void main(String[] args) {
        try {
        	System.out.println(1 / 0);
        }
        catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }
    }
}
```

### 处理多种异常

```java
public class EHandle {
    public static void main(String[] args) {

        int y = 10;

        Scanner scanner = new Scanner(System.in);

        try {
        	System.out.print("输入一个整数: ");
            int x = scanner.nextInt();
            System.out.println(y / x);
        }
        catch (InputMismatchException e) {
            System.out.println("输入的不是整数");
        }
        catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }
    }
}
```

### 捕获所有异常 (不推荐)

可以使用 `catch (Exception e)` 来捕获所有异常

```java
public class EHandle {
    public static void main(String[] args) {
        try {
        	System.out.println(1 / 0);
        }
        catch (Exception e) {
            System.out.println("发生异常！");
        }
    }
}
```

### 使用 `finally{}` 块

`finally{}` 块无论是否出现异常，都要执行的代码，一般用于**关闭资源**

```java
public class EHandle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
        	System.out.print("输入一个整数: ");
            int x = scanner.nextInt();
            System.out.println(x);
        }
        catch (InputMismatchException e) {
            System.out.println("输入的不是整数");
        }
        finally {
            scanner.close();
            System.out.println("Scanner已关闭");
        }
    }
}
```

输入 `123`

```bash
输入一个整数: 123
123
Scanner已关闭
```

输入 `abc`
```bash
输入一个整数: abc
输入的不是整数
Scanner已关闭
```

可以看到，无论是否出现异常，`finally{}` 块都会执行