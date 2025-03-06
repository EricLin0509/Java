# 抽象关键字

## 定义

抽象——定义抽象类或抽象方法的过程

- 抽象是一个隐藏实现细节的过程，只能展示必要的信息
- 抽象类不能直接实例化

可以理解为：

你开车，你只需要知道方向盘、油门、刹车、方向盘等，不需要知道发动机、轮胎、底盘、车身等

## 代码示例

### 定义抽象类

使用 `abstract` 关键字定义抽象类

```java
// Shape.java

public abstract class Shape {
}
```

### 定义子类并继承抽象类

```java
// Circle.java

public class Circle extends Shape {
}
```

### 尝试实例化抽象类

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
    }
}
```

```
Error:(2, 13) java: Shape是抽象的; 无法实例化
```

可以看到，抽象类不能直接实例化

### 定义抽象方法

使用 `abstract` 关键字定义抽象方法

```java
// Shape.java

public abstract class Shape {
    public abstract void area();
}
```

此时，`Circle.java` 会报错

```
Error:(4, 16) java: Circle中的area()无法实现Shape中的area()
```

这是因为抽象方法没有实现，需要在子类中实现

```java
// Circle.java

public class Circle extends Shape {
    
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override // 重写父类的抽象方法
    double area() {
        return Math.PI * radius * radius;
    }
}
```

与普通方法不同，抽象方法没有方法体，需要在子类中实现

### 调用抽象方法

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println("圆的面积：" + circle.area());
    }
}
```

### 具体方法

与抽象方法相反的是具体方法 (concrete methods)，具体方法有方法体

```java
// Shape.java

public abstract class Shape {
    
    public abstract void area(); // 抽象方法

    public void display() { // 具体方法
        System.out.println("这是一个图形");
    }
}
```

### 调用具体方法

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.display();
    }
}
```

## 总结

- 抽象类不能直接实例化
- 抽象方法没有方法体
- 抽象方法需要在子类中实现
- 具体方法有方法体