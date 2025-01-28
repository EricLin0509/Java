# While 循环

## 定义

While 循环是一种重复执行语句的控制结构，直到指定的条件不再满足为止

## 语法

### while 语句写法

```java
while (条件) {
    语句1
    ...
    语句n
}
```

### 代码示例

```java
while (name.isEmpty()) { // 当 name 为空时
    System.out.print("Enter your name");
    name = scanner.nextLine();
}
```

[源代码](While.java)

# do-while 循环

## 定义
do-while 循环是一种重复执行语句的控制结构，直到指定的条件不再满足为止

## 语法

### do-while 语句写法

```java
do {
    语句1
   ...
    语句n
} while (条件);
```

### 代码示例

```java
do {
    System.out.print("Enter your name");
    name = scanner.nextLine();
} while (name.isEmpty()); // 当 name 为空时
```

[源代码](DoWhile.java)

# 两者区别

| while 循环 | do-while 循环 |
| :--------: | :-----------: |
| 先判断后执行 | 先执行后判断 |
| 可能一次都不执行 | 至少执行一次 |
