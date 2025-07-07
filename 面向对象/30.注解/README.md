# 注解

在 Java 中，注解 (Annotation) 是一种元数据，它可以附加到代码中，用于提供信息给编译器或其他工具。注解可以用来指定某些属性，如变量、类、方法、字段等的元数据。注解可以用来实现 AOP (Aspect-Oriented Programming)、日志记录、安全检查、性能调优等

## 语法

```java
public @interface 注解名 {
    // 属性列表
}
```

## 代码示例

假设现在有一个 `Cat` 类

```java
// Cat.java

public class Cat {
    private String name;
    private int age;
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}
```

现在，我们想给 `Cat` 类添加一个注解 `@Animal`

```java
// Animal.java

public @interface Animal {    }
```

但是，现在 `@Animal` 注解可以在任何地方使用，这一般不是我们想要的

那么可以使用 `@Target` 注解来指定注解可以作用的位置

### `@Target` 注解

`@Target` 注解用来指定注解可以作用的位置

可以作用的位置有以下几种：

- `ElementType.TYPE`：作用于类、接口、注解
- `ElementType.FIELD`：作用于成员变量
- `ElementType.METHOD`：作用于方法
- `ElementType.PARAMETER`：作用于方法参数
- `ElementType.CONSTRUCTOR`：作用于构造函数
- ......

```java
// Animal.java

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target(ElementType.TYPE) // 允许作用于类、接口、注解
public @interface Animal {    }
```

现在 `@Animal` 注解只能作用于类、接口、注解

**不能作用于成员变量、方法、方法参数、构造函数等**

#### 允许多个地方

使用 `{}` 来指定多个位置

```java
// Animal.java

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target({ElementType.TYPE, ElementType.METHOD}) // 允许作用于类、接口、注解、方法
public @interface Animal {    }
```

现在 `@Animal` 注解可以作用于类、接口、注解、方法

### `@Retention` 注解

`@Retention` 注解用来指定注解的生命周期

- `RetentionPolicy.SOURCE`：在编译器进行编译时丢弃，在运行时无法使用
- `RetentionPolicy.CLASS`：在编译器进行编译时保留，在运行时无法使用
- `RetentionPolicy.RUNTIME`：在编译器进行编译时丢弃，在运行时可以获取到注解的信息


一般情况下，我们只需要使用 `RetentionPolicy.RUNTIME` 即可

```java
// Animal.java

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE, ElementType.METHOD}) // 允许作用于类、接口、注解、方法
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
public @interface Animal {    }
```

### 调用注解

```java
// Cat.java

@Animal
public class Cat {
    ...
}
```

### `isAnnotationPresent`

`isAnnotationPresent` 方法用来判断某个类是否有某个注解

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 1);

        if (cat.getClass().isAnnotationPresent(Animal.class)) {
            System.out.println("This is an animal.");
        }
        else {
            System.out.println("This is not an animal.");
        }

        Car car = new Car("BMW", "M5 Competition");

        if (car.getClass().isAnnotationPresent(Animal.class)) {
            System.out.println("This is an animal.");
        }
        else {
            System.out.println("This is not an animal.");
        }
    }
}
```

```
This is an animal.
This is not an animal.
```

### 添加参数列表

```java
// Cat.java

@Animal(Type = "Cat")
```

此时会报错：

```
The attribute Type is undefined for the annotation type Animal
```

这是因为 `@Animal` 注解没有定义 `Type` 属性，我们需要在 `@Animal` 注解中添加 `Type` 属性

**注意：使用 `类型 属性名()` 来定义属性**

```java
// Animal.java

public @interface Animal {
    String Type(); // 定义 Type 属性
}
```

**注意：这里的类型只能是基本类型、String、数组**

#### 设置默认值

使用 `default` 关键字来设置默认值

```java
// Animal.java

public @interface Animal {
    String Type() default "Animal"; // 设置默认值
}
```

### `getAnnotation`

`getAnnotation` 方法用来获取某个类某个注解的属性

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 1);
        Animal annotation = cat.getClass().getAnnotation(Animal.class); // 获取 Cat 类的 Animal 注解

        if (annotation != null) {
            System.out.println("This is a " + annotation.Type() + "."); // 获取注解中 Type 属性的值
        }
        else {
            System.out.println("This is not an animal.");
        }
    }
}
```

```
This is a Cat.
```