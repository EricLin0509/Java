# 对象概念

## 对象的定义

- 对象
    - 包含数据的实体 (属性)
    - 可以执行操作 (方法)
    - 是一种引用数据类型
    - 一般存储在堆区

## 代码示例

**在Java中，类 (`class`) 相当于一个用于创造对象的蓝图**

### 创建一个新的类用于创建对象

```java
// Car.java
public class Car { // Car类
    String menufacturer = "BMW";
    String model = "E46 M3 CSL";
    int year = 2003;
    boolean isRunning = false;
}
```

### 创建对象

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        Car car = new Car(); // 创建一个Car对象
        System.out.println(car.menufacturer);
        System.out.println(car.model);
        System.out.println(car.year);
        System.out.println(car.isRunning);
    }
}
```

### 在对象中调用方法

```java
// Car.java
public class Car {
    String menufacturer = "BMW";
    String model = "E46 M3 CSL";
    int year = 2003;
    boolean isRunning = false;

    void start() {
        isRunning = true;
        System.out.println("车辆已启动");
    }

    void stop() {
        isRunning = false;
        System.out.println("车辆已停止");
    }
}
```

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        System.out.println(car.isRunning);
    }
}
```