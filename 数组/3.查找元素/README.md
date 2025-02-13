# 查找元素

## 步骤

1. 设置目标值
2. 遍历数组
3. 比较元素
4. 返回元素下标
5. 确认是否存在目标值

## 整形数组示例

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
```

### 设置目标值

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
int target = 17;
```

### 遍历数组

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
int target = 17;

for (int i = 0; i < nums.length; i++) {   }
```

### 比较元素

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
int target = 17;

for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target) {   }
}
```

### 返回元素下标

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
int target = 17;

for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target) {
        System.out.println("在数组中找到了目标值，下标为：" + i);
    }
}
```

### 确认是否存在目标值

```java
int[] nums = {1, 4, 7, 9, 12, 15, 17, 19, 21};
int target = 17;
boolean isFound = false;

for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target) {
        System.out.println("在数组中找到了目标值，下标为：" + i);
        isFound = true;
    }

    if (!isFound) {
        System.out.println("在数组中没有找到目标值");
    }
}
```

## 字符串数组示例

```java
String[] fruits = {"apple", "banana", "orange"};
```

### 设置目标值
```java
String[] fruits = {"apple", "banana", "orange"};
String target = "orange";
```

### 遍历数组
```java
String[] fruits = {"apple", "banana", "orange"};
String target = "orange";
for (int i = 0; i < fruits.length; i++) {   }
```

### 比较元素

**不能直接比较字符串，需要使用 `equals()` 方法**

```java
String[] fruits = {"apple", "banana", "orange"};
String target = "orange";
for (int i = 0; i < fruits.length; i++) {
    if (fruits[i].equals(target)) {   }
}
```

### 返回元素下标

```java
String[] fruits = {"apple", "banana", "orange"};
String target = "orange";
for (int i = 0; i < fruits.length; i++) {
    if (fruits[i].equals(target)) {
        System.out.println("在数组中找到了目标值，下标为：" + i);
    }
}
```

### 确认是否存在目标值

```java
String[] fruits = {"apple", "banana", "orange"};
String target = "orange";
boolean isFound = false;

for (int i = 0; i < fruits.length; i++) {
    if (fruits[i].equals(target)) {
        System.out.println("在数组中找到了目标值，下标为：" + i);
        isFound = true;
    }
}
if (!isFound) {
    System.out.println("在数组中没有找到目标值");
}
```