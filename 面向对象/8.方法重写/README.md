# 方法重写 (Method Override)

## 定义

- 子类中出现与父类一模一样的方法(包括返回值类型,函数名和参数列表)
- 用于代码可重用性和专门的功能扩展

## 代码示例

### 父类

```java
// Animal.java

public class Animal {
    void move() {
        System.out.println("This animal is running...");
    }
}
```

### 子类
```java
// Cat.java

public class Cat extends Animal  {    
}
```

```java
// Dog.java

public class Dog extends Animal {
}
```

```java
// Fish.java

public class Fish extends Animal {
}
```

### 创建子类对象

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();

        cat.move();
        dog.move();
        fish.move(); // 鱼是在水中移动的
    }
}
```

### 运行

```
This animal is running...
This animal is running...
This animal is running...
```

可以看到，子类没有重写父类的方法，所以调用的是父类的方法，但是我们希望鱼是在水中移动的，所以我们需要重写父类的方法

## 重写方法

```java
// Fish.java

public class Fish extends Animal {
    
    @Override // 用于标识这是一个重写方法
    void move() {
        System.out.println("This animal is swimming...");
    }
}
```

- @Override 是一个注解，用于标识这是一个重写方法

假如我们把 `move()` 方法的名字写错了，那么弹出警告

```java
// Fish.java
public class Fish extends Animal {

    @Override
    void moves() {
        System.out.println("This animal is swimming...");
    }
}
```

此时弹出警告

```
The method moves() of type Fish must override or implement a supertype method
```

所以，`@Override` 是一个非常好的习惯，可用于检查是否有拼写错误

### 运行

```
This animal is running...
This animal is running...
This animal is swimming...
```

可以看到，子类重写了父类的方法，所以调用的是子类的方法