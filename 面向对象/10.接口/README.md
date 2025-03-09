# 接口

## 定义

在Java中，接口是一种规范，它定义了一组方法的签名，但没有提供具体的实现。接口可以被类实现，从而实现接口中定义的方法

## 语法

```java
public interface 接口名 {
    // 方法签名
    返回类型 方法名(参数列表);
}
```

## 代码示例

### 定义接口

```java
// Hunt.java

public interface Hunt {   
}
```

```java
// Run.java

public interface Run {   
}
```

### 设置方法

```java
// Hunt.java

public interface Hunt {
    void hunt();
}
```

```java
// Run.java

public interface Run {   
    void run();
}
```

### 设置类并调用接口

```java
// Cat.java

public class Cat implements Hunt {
}
```

此时会发生报错，因为`Cat`类没有实现`Hunt`接口中的方法

```
The type Cat must implement the inherited abstract method Hunt.hunt()
```

### 实现接口中的方法

由于接口中的方法**默认都是 `public` 的，所以在子类中也必须使用 `public` 修饰符**

```java
// Cat.java

public class Cat implements Hunt {

    @Override // 重写接口中的方法
    public void hunt() {
        System.out.println("The cat is hunting...");
    }

}
```

### 调用多个接口

```java
// Fish.java

public class Fish implements Run, Hunt {
    
    @Override
    public void hunt() {
        System.out.println("The fish is hunting...");
    }

    @Override
    public void run() {
        System.out.println("The fish is swimming away...");
    }
}
```

### 创建对象并调用方法

```java
public class Main {
    public static void main(String[] args) {
        
        Cat cat = new Cat();
        Fish fish = new Fish();

        cat.hunt();
        fish.hunt();
        fish.run();

    }
}
```

### 运行结果

```
The cat is hunting...
The fish is hunting...
The fish is swimming away...
```