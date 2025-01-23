# 三元运算符

## 之前的 if...else 语句

```java
    int score = 55;

    if (score >= 60) {
        System.out.println("及格");
    } else {
        System.out.println("不及格");
    }
```

## 三元运算符的定义

三元运算符是由三部分组成的一个运算符，格式如下：

变量 = 条件判断 ? 表达式A **(TRUE)** : 表达式B **(FALSE)**;

## 代码示例

```java
    int score = 55;
    
    String result = score >= 60 ? "及格" : "不及格";
    System.out.println(result);
```

[源代码](ternary.java)

## 两者的区别

| 区别 | if...else | 三元运算符 |
| :--: | :-------: | :--------: |
|  格式  |  完整格式  |  简洁格式  |
| 易读性 |    易读    |    不易读   |