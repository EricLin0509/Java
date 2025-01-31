# For 循环

## 定义

for 循环是一种重复执行语句的方法，指定运行多少次

## 语法

### for 语句写法

```java
for (初始化; 布尔表达式; 更新) {
    语句1
    ...
    语句n
}
```

- 初始化：初始化循环变量，只执行一次
- 布尔表达式：循环条件，TRUE 则继续循环
- 更新：更新循环变量，执行完代码块后执行

### 代码示例

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

#### 更改迭代步长

```java
for (int i = 0; i < 10; i += 2) {
    System.out.println(i);
}
```

[源代码](forloop.java)