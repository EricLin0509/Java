# 多态 (Polymorphism)

## 定义

多态是指在父类中定义的属性和方法被子类继承之后，可以具有不同的数据类型或表现出不同的行为。这使得同一个方法在不同的子类中可以有不同的实现，从而增加了程序的灵活性和可扩展性

## 实现

### 创建抽象父类

```java
// Vehicle.java

public abstract class Vehicle {

    abstract void go();

}
```

### 创建子类

```java
// Car.java

public class Car extends Vehicle {
    
    @Override
    void go() {
        System.out.println("Driving a car");
    }

}
```

```java
// Bike.java

public class Bike extends Vehicle {

    @Override
    void go() {
        System.out.println("Riding a bike");
    }
}
```

### 创建对象

```java
// Main.java

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

    }
}
```

但是现在我们要将 `car` 和 `bike` 都添加到一个数组中，然后遍历数组，调用每个对象的 `go()` 方法
那么应该使用什么类型的数组呢？

### 尝试使用 `Car[]`

```java
// Main.java

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

        Car[] vehicles = new Car[]{car, bike};

    }
}
```

可是这样会报错

```
Type mismatch: cannot convert from Bike to Car
```

因为 `Car[]` 只能存储 `Car` 类型的对象，而 `Bike` 不是 `Car` 的子类

### 解决方案——多态

由于 `Car` 和 `Bike` 都继承了 `Vehicle`，所以可以使用 `Vehicle[]` 来存储 `Car` 和 `Bike`

```java
// Main.java

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

        Vehicle[] vehicles = new Car[]{car, bike};

    }
}
```

### 遍历数组

```java
// Main.java

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

        Vehicle[] vehicles = new Car[]{car, bike};

        for (Vehicle vehicle : vehicles) {
            vehicle.go();
        }

    }
}
```

### 将父类改成接口

使用接口也可以实现多态

```java
// Vehicle.java

public interface Vehicle {
    void go();
}
```

```java
// Car.java

public class Car implements Vehicle {

    @Override
    public void go() {
        System.out.println("Driving a car");
    }

}
```

```java
// Bike.java

public class Bike implements Vehicle {

    @Override
    public void go() {
        System.out.println("Riding a bike");
    }

}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

        Vehicle[] vehicles = new Vehicle[]{car, bike};
        
        for (Vehicle vehicle : vehicles) {
            vehicle.go();
        }
        
    }
}