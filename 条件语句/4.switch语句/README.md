# switch 语句

## 之前的 if...else 语句

例如写一个判断是否是工作日的程序

```java
if (day.equals("Monday")) {
    System.out.println("It's Monday.");
}
else if (day.equals("Tuesday")) {
    System.out.println("It's Tuesday.");
}
else if (day.equals("Wednesday")) {
    System.out.println("It's Wednesday.");
}
else if (day.equals("Thursday")) {
    System.out.println("It's Thursday.");
}
else if (day.equals("Friday")) {
    System.out.println("It's Friday.");
}
else if (day.equals("Saturday")) {
    System.out.println("It's Saturday.");
}
else if (day.equals("Sunday")) {
    System.out.println("It's Sunday.");
}
else {
    System.out.println("Invalid day.");
}
```

可以看到，这种写法非常复杂，而且容易出错

## 使用 switch 语句

### switch 语句的基本语法

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


#### 多个条件合并

```java
switch (表达式) {
    case 常量1, 常量2, 常量3 -> 语句1;
    case 常量4, 常量5, 常量6, 常量7 -> 语句2;
    ...
    default 语句n -> 语句n;
}
```

### 代码示例

```java
switch(day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
            System.out.println("It's a weekday");

    case "Saturday", "Sunday" ->
             System.out.println("It's a weekend");

    default-> System.out.println("Invalid day");
}
```

[源代码](enhancedswitch.java)