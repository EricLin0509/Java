# 组合体 (Composition)

## 定义

- 组合体代表类之间 **'part-of'** 关系
    - part-of 关系是指一个整体拥有一个或多个部分，并且整体和部分之间具有整体拥有部分的语义
- 组合体是**一个整体**，而整体的部分是可以改变或被改变的，整体与部分间的依赖关系具有互反性，即部分会影响整体，整体也会影响部分
    - 例如：发动机是汽车的一部分，汽车是发动机的整体
- 组合体可以将一个**复杂的系统分解为多个简单的部分**，从而提高系统的可维护性和可扩展性

## 代码示例

### 创建一个 `Car` 类

```java
// Car.java

public class Car {

    String model;
    int year;
    Engine engine;

    Car(String model, int year,String engineType) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType); // 使用组合关系创建 Engine 对象
    }

}
```

### 创建一个 `Engine` 类
```java
// Engine.java

public class Engine {
    
    String type;

    Engine(String type) {
        this.type = type;
    }

}
```

### 测试
```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Car car = new Car("Honda Civic Type R (FD2)", 2007, "K20A");

        System.out.println(car.model);
        System.out.println(car.year);
        System.out.println(car.engine);

    }
}
```

```
Honda Civic Type R (FD2)
2007
Engine@762efe5d
```

但是，我们可以看到，输出 `car.engine` 是 `engine` 对象的地址，并不是我们想要的 `K20A`

这是因为我们在 `Car` 类中使用了组合关系创建了一个 `car.engine` 对象，`Car` 类和 `Engine` 类之间的关系是 **'part-of'** 关系

**此时需要 `car.engine.type` 来获取 `car.engine` 对象的属性**


#### 解决

```java
// Car.java

public class Main {
    public static void main(String[] args) {
        
        Car car = new Car("Honda Civic Type R (FD2)", 2007, "K20A");

        System.out.println(car.model);
        System.out.println(car.year);
        System.out.println(car.engine.type);

    }
}
```

```
Honda Civic Type R (FD2)
2007
K20A
```

### 使用组合关系创建方法

```java
// Engine.java

public class Engine {
    
    String type;

    Engine(String type) {
        this.type = type;
    }

    void start() {
        System.out.println("Engine " + type + " is started");
    }

}
```

```java
// Car.java

public class Car {

    String model;
    int year;
    Engine engine;

    Car(String model, int year, String engineType) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType);
    }

    void start() {
        this.engine.start(); // 使用组合关系调用 Engine 类的方法
        System.out.println("The " + model + " is started");
    }

}
```

```
Engine K20A is started
The Honda Civic Type R (FD2) is started
```

## 区别

### 组合体与聚合体

- 组合体是一种强耦合关系，整体和部分之间具有整体拥有部分的语义
- 聚合体是一种弱耦合关系，整体和部分之间没有整体拥有部分的语义

### 组合体与抽象类

- 抽象类能够为其指定名称并在不同上下文中重复使用它
- 组合体用于将简单函数组合成更复杂函数

