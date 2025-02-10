# 数组

## 定义

数组是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据

## 语法

### 数组声明

```java
数据类型[] 数组名;
```

### 代码示例

#### 定义一个数组

```java
String[] fruits = {"apple", "orange", "banana"};
```

#### 打印数组

```java
System.out.println(fruits);
```

##### 输出

```bash
[Ljava.lang.String;@15db9742
```

##### 原因

数组是一个对象，所以打印出来的是对象的地址

##### 正确的打印方式

```java
System.out.println(Arrays[0]);
```

##### 输出

```bash
apple
```

##### 尝试打印不存在的元素

```java
System.out.println(fruits[3]);
```

##### 输出
```bash
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
```

#### 修改数组元素

```java
fruits[0] = "pear";
System.out.println(fruits[0]);
```

##### 输出

```bash
pear
```

### 数组方法

#### 获取数组长度

```java
int length = fruits.length;
```

##### 示例

```java
for (int i = 0; i < fruits.length; i++) {
    System.out.println(fruits[i]);
}
```

#### 遍历数组

```java
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

#### 数组排序

先引入 `java.util.Arrays` 库

```java
import java.util.Arrays;
```

使用 `Arrays.sort()` 方法
```java
int nums[] = {1, 5, 3, 2, 4};
Arrays.sort(nums);
```

`Arrays.sort()` 方法会将数组进行升序排序

#### 数组填充

使用 `Arrays.fill()` 方法

```java
int nums[] = {1, 5, 3, 2, 4};
Arrays.fill(nums, 0);
```

`Arrays.fill()` 方法会将数组中的所有元素填充为指定的值