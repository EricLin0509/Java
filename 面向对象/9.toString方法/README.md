# toString方法 (Object.toString)

## 定义

- 方法继承与Object类，返回一个表示对象的字符串
- 在默认情况下，toString方法返回一个对象的类名、@符号和对象的哈希码的无符号十六进制表示
- 它可以被任何类重写，以改变返回的字符串

## 代码示例

### 创建对象

```java
// Car.java

public class Car {

    String menufacturer;
    String model;
    int year;
    String colour;

    Car(String make, String model, int year, String color) {
        this.menufacturer = make;
        this.model = model;
        this.year = year;
        this.colour = color;
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Car car = new Car("BMW", "E46 M3 CSL", 2003, "Silver");
        System.out.println(car);

    }
}
```

### 运行

```
Car@2401f4c3
```

可以看到，输出的是类名、@符号和对象的哈希码的无符号十六进制表示

### 输出信息

```java
System.out.println(car.menufacturer + " " + car.model + " " + car.year + " " + car.colour);
```

但是，这样的输出方式比较麻烦，我们可以重写toString方法，改变输出的字符串

### 重写toString方法

```java
// Car.java
public class Car {

    String menufacturer;
    String model;
    int year;
    String colour;

    Car(String make, String model, int year, String color) {
        this.menufacturer = make;
        this.model = model;
        this.year = year;
        this.colour = color;
    }

    @Override // 重写toString方法
    public String toString() {
        return colour + " " + year + " " + menufacturer + " " + model;
    }

}
```

#### 调用

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Car car = new Car("BMW", "E46 M3 CSL", 2003, "Silver");
        System.out.println(car);

    }
}
```

### 运行

```
Silver 2003 BMW E46 M3 CSL
```

可以看到，输出的字符串已经改变了