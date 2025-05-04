# Lambda 表达式

## 定义

在 Java 中，Lambda 表达式是一种简洁的函数式编程方式，它允许我们将函数作为参数传递给其他函数。Lambda 表达式通常用于替代匿名内部类的使用，使得代码更加简洁易读

## 语法

```java
方法名(
    (参数列表) -> {
        // 方法体
    };
)
```

**注意：Lambda 表达式只能用于函数式接口，即只有一个抽象方法的接口**

## 代码示例

假设现在有两个类和一个接口

```java
// Printable.java

public interface Printable {
    void print();
}
```

```java
// Cat.java

public class Cat implements Printable {
    @Override
    public void print() {
        System.out.println("Meow!");
    }
}
```

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.print();
    }
}
```

```
Meow!
```

现在，在 Lambda.java 中，有一个方法，它接受一个 Printable 对象作为参数，并调用其 print 方法

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Cat cat = new Cat();
        printThings(cat);
    }

    public static void printThings(Printable printable) {
        printable.print();
    }
}
```

```
Meow!
```

但是这样需要创建一个 Cat 对象，然后将其传递给 print 方法

那么我们可以使用 Lambda 表达式来简化这个过程

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        printThings(
            () -> {
                System.out.println("Meow!");
            }
        );
    }

    public static void printThings(Printable printable) {
        printable.print();
    }
}
```

```
Meow!
```

**这样相当于传递实现了 Printable 接口的函数**

### 简化

如果方法体只有一行代码，可以省略大括号

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        printThings(() -> System.out.println("Meow!"));
    }

    public static void printThings(Printable printable) {
        printable.print();
    }
}
```

或者

```java
// Lambda.java
public class Lambda {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Meow!");
        printThings(printable);
    }
    public static void printThings(Printable printable) {
        printable.print();
    }
}
```

```
Meow!
```


### 参数传递

假设接口中的方法有参数

```java
// Printable.java

public interface Printable {
    void print(String str);
}
```

那么在 Lambda 表达式中，要在前面的括号中传入参数

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Printable printable = (str) -> System.out.println(str + " Meow!");
        printThings(printable);
    }
    
    public static void printThings(Printable printable) {
        printable.print("Meow!");
    }
}
```

```
Meow! Meow!
```

如果参数有多个，要用逗号分隔

```java
// Printable.java

public interface Printable {
    void print(String str1, String str2);
}
```

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Printable printable = (str1, str2) -> System.out.println(str1 + " " + str2 + " Meow!");
        printThings(printable);
    }

    public static void printThings(Printable printable) {
        printable.print("Meow!", "Meow!");
    }
}
```

```
Meow! Meow! Meow!
```

### 返回值

如果方法有返回值，那么在方法体中可以不用 return 关键字

```java
// Printable.java

public interface Printable {
    String print(String str1, String str2);
}
```

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Printable printable = (str1, str2) -> str1 + " " + str2 + " Meow!";
        System.out.println(printThings(printable));
    }

    public static String printThings(Printable printable) {
        return printable.print("Meow!", "Meow!");
    }
}
```

```
Meow! Meow! Meow!
```

如果方法体有多行代码，那么必须使用 return 关键字和大括号

```java
// Lambda.java

public class Lambda {
    public static void main(String[] args) {
        Printable printable = (str1, str2) -> {
            String result = str1 + " " + str2 + " Meow!";
            System.out.println(result);
            return result;
        };
        System.out.println(printThings(printable));
    }

    public static String printThings(Printable printable) {
        return printable.print("Meow!", "Meow!");
    }
}
```

```
Meow! Meow! Meow!
Meow! Meow! Meow!
```

