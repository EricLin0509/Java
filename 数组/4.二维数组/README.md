# 二维数组

## 定义

二维数组是指以行和列的方式排列的数组

## 语法

### 二维数组的声明

```java
变量类型[][] 数组名;
```

#### 代码示例

合并不同种类的食物

```java
String[] fruits = { "apple", "banana", "orange" };
String[] vegetables = { "carrot", "potato", "beetroot" };
String[] meats = { "chicken", "pork", "beef" };

String[][] groceries = { fruits, vegetables, meats };
```

### 遍历二维数组

```java
for(String[] foods : groceries) {
    for(String food : foods) {
        System.out.print(food + " ");
    }
    System.out.println();
}
```

### 直接创建

```java
int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
```

### 修改二维数组

```java
array[0][0] = 10; // 将数组中的第一个元素修改为 10
```

[源代码](twodarray.java)