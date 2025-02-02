# 循环嵌套

## 定义

循环嵌套是指在一个循环语句中再定义一个循环语句的语法结构

一般用于矩阵、二维数组等的运算

## 循环嵌套的写法

## for循环嵌套

```java
for(初始化表达式; 布尔表达式; 更新表达式) {
    for(初始化表达式; 布尔表达式; 更新表达式) {
        语句;
    }
}
```

**注意：初始化表达式变量必须不同**

### 代码示例

#### 错误示例

```java
for(int z = 0; z < 3; z++) {
    for(int z = 1; z < 10; z++) {
        System.out.print(z + " ");
    }
    System.out.println();
}
```

#### 正确示例

```java
for(int i = 0; i < 3; i++) {
    for(int j = 1; j < 10; j++) {
        System.out.print(j + " ");
    }
    System.out.println();
}
```

## while循环嵌套

```java
while(布尔表达式) {
    while(布尔表达式) {
        语句;
    }
}
```

### 代码示例

```java
int i = 0;
while(i < 3) {
    int j = 1;
    while(j < 10) {
        System.out.print(j + " ");
        j++;
    }
    System.out.println();
    i++;
}
```

[源代码](nestedloop.java)
