# 泛型

## 定义

泛型是指在定义函数、接口或类的时候，不预先指定具体的类型，而在使用的时候再指定类型的一种特性

在Java中，泛型的使用是广泛的，比如List、Map、Set等集合类都使用了泛型

## 场景

假设现在有一个可以输出一个 `Integer` 类型的 `Printer` 类

```java
public class IntegerPrinter {
    Integer value;
    public IntegerPrinter(Integer value) {
        this.value = value;
    }
    public void print() {
        System.out.println(value);
    }
}
```

但是现在有一个需求，需要输出一个 `String` 类型的 `Printer` 类

我们可以直接复制 `IntegerPrinter` 类，然后将 `Integer` 类型改为 `String` 类型

```java
public class StringPrinter {
    String value;
    public StringPrinter(String value) {
        this.value = value;
    }
    public void print() {
        System.out.println(value);
    }
}
```

但是这样会有一个问题，就是代码重复，如果有多个类型需要输出，就需要复制多次，这样会造成代码冗余

**那么我们可以使用泛型来解决这个问题**

## 语法

```java
public class 类名<泛型标记符> {
    泛型标记符 变量名; // 声明泛型变量
    public 类名(泛型标记符 变量名) { // 构造函数
        this.变量名 = 变量名;
    }
    public void 方法名(泛型标记符 变量名) { // 方法
        System.out.println(变量名);
    }
}
```

有以下几种泛型标记符

- T —— Type (类型)
- E —— Element (元素)
- K —— Key (键)
- V —— Value (值)
- N —— Number (数字)
- ? —— 表示不确定的 java 类型

**注意：泛型只能用于类，不能用于基本类型**

例如 `ArrayList<int>` 是错误的

## 代码示例

```java
// Printer.java

public class Printer<T> {
    T value;
    public Printer(T value) {
        this.value = value;
    }
    public void print() {
        System.out.println(value);
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(1);
        integerPrinter.print();
        Printer<String> stringPrinter = new Printer<>("Hello World");
        stringPrinter.print();
    }
}
```

```
1
Hello World
```

这样就能获得一个通用的 `Printer` 类了

## 泛型的继承

泛型可以继承，比如 `Printer<T extends Animal>` 表示 `T` 必须是 `Animal` 类型或者 `Animal` 类型的子类

```java
// Animal.java

public class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Animal speak");
    }
}
```

```java
// Cat.java

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Meow");
    }
}
```

```java
// Printer.java

public class Printer<T extends Animal> {
    T value;
    public Printer(T value) {
        this.value = value;
    }
    public void print() {
        value.speak();
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Printer<Cat> catPrinter = new Printer<>(new Cat("Tom"));
        catPrinter.print();
    }
}
```

```
Meow
```

## 泛型方法

泛型也可以用于方法，比如 `public <T> void print(T value)` 表示 `print` 方法可以接收任何类型的参数

```java
public static <T> void print(T value) {
    System.out.println(value);
}
```

### 可以传递多个泛型

```java
public static <T, V> void print(T value1, V value2) {
    System.out.println(value1 + " " + value2);
}
```

### 也可以用于返回值类型

```java
public static <T> T get(T value) {
    return value;
}
```

## Wildcard

泛型也可以使用 `?` 来表示不确定的类型，比如 `List<?>` 表示 `List` 可以存储任何类型的对象

```java
List<?> list = new ArrayList<>();
```

## 用处

### 类型安全

泛型的主要目的是提供类型安全。通过在使用中限制类型，我们可以避免在运行时出现 ClassCastException

假设现在有 `Car` 和 `Boat` 两个类

```java
Car[] cars = new Car[10];
cars[0] = new Boat(); // 运行时错误
```
此时会出现**运行时错误**，因为 `Car` 类型的数组只能存储 `Car` 类型的对象

但是如果使用泛型，就可以避免这个问题

```java
ArrayList<Car> cars = new ArrayList<>();
cars.add(new Boat()); // 编译错误
```

此时会出现**编译错误**，因为 `ArrayList` 只能存储 `Car` 类型的对象

这样就可以避免在运行时出现 `ClassCastException` 异常

### 代码复用

泛型的另一个好处是可以提高代码的复用性。通过泛型，我们可以编写一个通用的算法或数据结构，然后在不同的类型上使用

### 性能优化

泛型还可以提高性能。由于泛型的类型在编译时就确定了，所以编译器可以进行更多的优化，比如类型检查、类型转换等

### 可读性

泛型还可以提高代码的可读性。通过泛型，我们可以在代码中明确地指定类型，从而使代码更易于理解和维护