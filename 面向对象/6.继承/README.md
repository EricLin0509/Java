# 继承 (Inheritance)

## 定义

继承是面向对象编程中一个非常重要的概念，它允许我们创建一个新的类，这个类是基于一个已有的类而构建的。新类被称为子类（subclass），而被继承的类被称为父类（superclass）。子类可以继承父类的属性和方法，并且可以添加自己的属性和方法

## 代码示例

### 创建一个父类

这里我们创建一个名为 `Animal` 的父类

```java
// Animal.java
public class Animal {
    
    bool isAlive;

    Animal() {
        isAlive = true;
    }

    void eat() {
        System.out.println("The animal is eating.");
    }
}
```

### 创建一个子类

这里我们创建一个名为 `Dog` 的子类，它继承了 `Animal` 类

**注意：子类只能继承一个父类**

```java
// Dog.java
public class Dog extends Animal {
}
```

### 创建子类对象

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.isAlive);
        dog.eat();
    }
}
```

#### 输出

```
true
The animal is eating.
```

可以看到，即使我们没有在 `Dog` 类中定义 `eat` 方法，它仍然可以调用父类的 `eat` 方法

### 为子类创造新的属性和方法

```java
// Dog.java
public class Dog extends Animal {

    int lives = 1;

    void speak() {
        System.out.println("The dog is barking.");
    }

}
```

### 调用子类的方法

```java
// Main.java
public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.speak();
        
    }
}