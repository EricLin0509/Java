# 自定义异常

## 定义

在 Java 中，我们可以通过继承 Exception 类来定义自定义异常

## 代码示例

### 抛出异常

假设现在有一个场景，要求输入年龄，如果输入的年龄小于 0 或大于 120，则抛出异常

```java
public class AgeInput {
    public static void main(String[] args) {
        validAge(121);
    }

    public static void validAge(int age) {
        if (age < 0 || age > 120) {
            
        }
    }
}
```

那此时需要定义一个类且**必须继承 `Exception` 类**

```java
public class InvalidAgeException extends Exception {
}
```

尝试调用此异常类

```java
public static void validAge(int age) {
    if (age < 0 || age > 120) {
        throw new InvalidAgeException();
    }
}
```

此时会报错: 

```
Unhandled exception: InvalidAgeException
```

这是因为我们没有处理异常，需要在方法签名中添加 `throws` 关键字

```java
public static void validAge(int age) throws InvalidAgeException {
    if (age < 0 || age > 120) {
        throw new InvalidAgeException();
    }
}
```

在 `main` 方法签名中也添加 `throws` 关键字

```java
public static void main(String[] args) throws InvalidAgeException {
    validAge(121);
}
```

或者使用 `try...catch` 语句处理异常

```java
public static void main(String[] args) {
    try {
        validAge(121);
    }
    catch (InvalidAgeException e) {
        System.out.println("Invalid age");
    }
}
```

**注意：如果是继承了 `RuntimeException` 类，则不需要在方法签名中添加 `throws` 关键字**

```java
public class InvalidAgeException extends RuntimeException {
    
}
```

```java
public static void validAge(int age) {
    if (age < 0 || age > 120) {
        throw new InvalidAgeException();
    }
}
```

### 自定义异常信息

需要在构造方法中添加异常信息

```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException() {} // 如果不想添加异常信息且已经有有参构造方法，则必须添加无参构造方法
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

```java
public static void validAge(int age) throws InvalidAgeException {
    if (age < 0 || age > 120) {
        throw new InvalidAgeException("Invalid age");
    }
}
```

### Throwable

`Throwable` 是所有异常的父类，它有两个子类：`Error` 和 `Exception`

- `Error`：表示系统级别的错误，例如内存溢出、栈溢出等
- `Exception`：表示程序级别的错误，例如空指针异常、数组越界异常等
    - `RuntimeException`：表示运行时异常，例如空指针异常、数组越界异常等
    - `CheckedException`：表示编译时异常，例如文件未找到异常、网络连接异常等

我们可以在异常类中的构造方法中添加 `Throwable` 类型的参数，用于输出异常原因

```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException() {} // 如果不想添加异常信息且已经有有参构造方法，则必须添加无参构造方法
    public InvalidAgeException(String message) {
        super(message);
    }
    public InvalidAgeException(Throwable cause) {
        super(cause);
    }
    public InvalidAgeException(String message, Throwable cause) { // 也可以添加异常信息和异常原因
        super(message, cause);
    }
}
```

```java
public static void validAge(int age) throws InvalidAgeException {
    if (age < 0 || age > 120) {
        throw new InvalidAgeException(new RuntimeException());
    }
}
```

如果报错，可以看到这一行

```
Caused by: java.lang.RuntimeException
```
