# Getter & Setter

## 定义

- 他们用于保护对象的的数据，添加规则用于限制对数据的访问和修改
- Getter —— 用于获取数据
- Setter —— 用于修改数据

## 代码示例

### 创建一个类

```java
// Car.java

public class Car {
    String brand;
    String model;
    String Colour;
    int year;

    Car(String brand, String model, String Colour, int year) {
        this.brand = brand;
        this.model = model;
        this.Colour = Colour;
        this.year = year;
    }
}
```

### 创建对象

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Car car = new Car("AUDI", "RS6 AVANT GT", 2025);
    }
}
```

因为`brand`, `model`, `year`都是`public`的，所以可以直接访问

### 将属性设置为`private`

```java
// Car.java

public class Car {
    private String brand;
    private String model;
    private String Colour;
    private int year;

    Car(String brand, String model, String Colour, int year) {
        this.brand = brand;
        this.model = model;
        this.Colour = Colour;
        this.year = year;
    }
}
```

这时会报错

```
The field Car.year is not visible
The field Car.brand is not visible
The field Car.Colour is not visible
The field Car.model is not visible
```

这是因为`brand`, `model`, `year`都是`private`的，所以不能直接访问

### 创建Getter

```java
// Car.java

public class Car {
    private String brand;
    private String model;
    private String Colour;
    private int year;

    Car(String brand, String model, String Colour, int year) {
        this.brand = brand;
        this.model = model;
        this.Colour = Colour;
        this.year = year;
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getColour() {
        return Colour;
    }
    int getYear() {
        return year;
    }
}
```

### 使用Getter

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Car car = new Car("AUDI", "RS6 AVANT GT", "White", 2025);
        System.out.println(car.getColour()+ " " + car.getBrand() + " " + car.getModel() + " " + car.getYear());
    }
}
```

现在可以通过Getter来访问属性了

### 创建Setter

由于只能修改`colour`，所以只创建`setColour`

```java
// Car.java

public class Car {
    private String brand;
    private String model;
    private String Colour;
    private int year;

    Car(String brand, String model, String Colour, int year) {
        this.brand = brand;
        this.model = model;
        this.Colour = Colour;
        this.year = year;
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getColour() {
        return Colour;
    }
    int getYear() {
        return year;
    }

    void setColour(String Colour) {
        this.Colour = Colour;
    }
}
```

### 使用Setter
```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Car car = new Car("AUDI", "RS6 AVANT GT", "White", 2025);
        System.out.println(car.getColour()+ " " + car.getBrand() + " " + car.getModel() + " " + car.getYear());

        car.setColour("Red");
        System.out.println(car.getColour()+ " " + car.getBrand() + " " + car.getModel() + " " + car.getYear());
    }
}
``` 

### 输出
```
White AUDI RS6 AVANT GT 2025
Red AUDI RS6 AVANT GT 2025
```

可以看到`colour`已经被修改了

## 总结

- Getter和Setter用于保护对象的数据，添加规则用于限制对数据的访问和修改

- 使用Getter和Setter可以使代码更加安全