# 将用户输入的内容写入数组

## 步骤

1. 定义一个数组
2. 循环读取用户输入的内容
3. 将用户输入的内容写入数组
4. 输出数组

## 代码示例

### 定义一个数组

```java
String[] foods = {}; // 空数组
```

#### 这里出现的问题

`foods` 是一个空数组，不能直接使用

#### 解决方案

```java
String[] foods = new String[3]; // 长度为3的数组
```


### 循环读取用户输入的内容并写入

```java
String[] foods = new String[3]; // 长度为3的数组

for (int i = 0; i < foods.length; i++) {
    System.out.print("请输入一种食物：");
    foods[i] = scanner.nextLine();
}
```

### 输出数组

```java
String[] foods = new String[3]; // 长度为3的数组

for (int i = 0; i < foods.length; i++) {
    System.out.print("请输入一种食物：");
    foods[i] = scanner.nextLine();
}

for (String food : foods) {
    System.out.println(food);
}
```

[源代码](intputarray.java)