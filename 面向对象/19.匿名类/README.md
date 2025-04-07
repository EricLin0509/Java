# 匿名类

## 定义

匿名类是指没有名字的类，**它不能重复使用，只能使用一次**

可以在不创建新的类的情况下，添加自定义行为

一般用于创建一个只使用一次的类

## 语法

```java
类名 对象名 = new 类名() {
    @Override
    // 自定义行为
};
```

## 代码示例

### 创建普通类和其对象

```java
// Dog.java

public class Dog {
    void bark() {
        System.out.println("Woof!");
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Dog dog1 = new Dog();
        dog1.bark();

    }
}
```

```
Woof!
```
#### 问题

现在有一个需求，需要创建一个 Dog 对象，但是这个 Dog 对象的行为是 "Bark!"

使用普通类的话，需要创建一个新的类和对象，但是这样会浪费资源

### 使用匿名类

使用匿名类的话，就可以在不创建新的类的情况下，添加自定义行为

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Dog dog1 = new Dog();
        dog1.bark();

        Dog dog2 = new Dog() {
            @Override
            void bark() {
                System.out.println("Bark!");
            }
        };
        dog2.bark();

    }
}
```

```
Woof!
Bark!
```