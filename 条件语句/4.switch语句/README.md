# switch 语句

## 之前的 if...else 语句

例如写一个判断是否是工作日的程序

```java
if (day.equals("Monday")) {
    System.out.println("It's a weekday.");
}
else if (day.equals("Tuesday")) {
    System.out.println("It's a weekday.");
}
else if (day.equals("Wednesday")) {
    System.out.println("It's a weekday.");
}
else if (day.equals("Thursday")) {
    System.out.println("It's a weekday.");
}
else if (day.equals("Friday")) {
    System.out.println("It's a weekday.");
}
else if (day.equals("Saturday")) {
    System.out.println("It's a weekend.");
}
else if (day.equals("Sunday")) {
    System.out.println("It's a weekend.");
}
else {
    System.out.println("Invalid day.");
}
```

可以看到，这种写法非常复杂，而且容易出错

## 使用 switch 语句

### switch 语句的基本语法

#### Java 12 之前的写法

```java
switch (表达式) {
    case 常量1:
        语句1;
        break;
    case 常量2:
        语句2;
        break;
   ...
    default:
        语句n;
        break;
}
```

#### Java 12 之后的写法

```java
switch (表达式) {
    case 常量1 -> 语句1;

    case 常量2 -> 语句2;
    ...
    default 语句n -> 语句n;
}
```

#### 注意事项

- `switch` 语句的表达式只能是 byte、short、int、char、String、枚举类型
- `case` 语句后面只能是常量，不能是变量
- `default` 语句可以省略
- `->` 是 Java 12 引入的新特性，用于简化 `case` 语句的写法

### 代码示例

```java
switch (day) {
    case "Monday" -> System.out.println("It's a weekday.");
    case "Tuesday" -> System.out.println("It's a weekday.");
    case "Wednesday" -> System.out.println("It's a weekday.");
    case "Thursday" -> System.out.println("It's a weekday.");
    case "Friday" -> System.out.println("It's a weekday.");

    case "Saturday" -> System.out.println("It's a weekend.");
    case "Sunday" -> System.out.println("It's a weekend.");

    default -> System.out.println("Invalid day.");
}
```

这里依旧出现了大量的重复代码，我们可以使用 `case` 语句的合并特性来简化代码

## case 语句的合并特性

### 基本语法

```java
switch (表达式) {
    case 常量1, 常量2, 常量3 -> 语句1;
    case 常量4, 常量5, 常量6, 常量7 -> 语句2;
    ...
    default -> 语句n;
}
```

#### 注意事项
- `case` 语句后面的常量可以是多个，用逗号隔开
- `case` 语句后面的常量的值不能重复

### 代码示例

```java
switch (day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
            System.out.println("It's a weekday");

    case "Saturday", "Sunday" ->
             System.out.println("It's a weekend");

    default -> System.out.println("Invalid day");
}
```

## 运行多个语句

### 基本语法
```java
switch (表达式) {
    case 常量1 -> {
        语句1;
        语句2;
        ...
        语句n;
    }
    case 常量2 -> {
        语句1;
        语句2;
        ...
        语句n;
    }
    ...
    default -> {
        语句1;
        语句2;
        ...
        语句n;
    }
}
```

### 代码示例

```java
switch (day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
        System.out.println("It's a weekday");
        System.out.println("Have a nice day");
    }

    case "Saturday", "Sunday" -> {
        System.out.println("It's a weekend");
        System.out.println("Have a nice weekend");
    }

    default -> System.out.println("Invalid day");
}
```

#### 注意事项
- `case` 语句后面的多个语句要用花括号括起来

[源代码](enhancedswitch.java)