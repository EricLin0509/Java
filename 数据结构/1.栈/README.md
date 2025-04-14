# 栈

## 概念

栈是一种特殊的线性表，只能在一端进行操作

- 栈顶 —— 栈的插入和删除操作都在栈顶进行
- 栈底 —— 栈的插入和删除操作都在栈底进行
- 特点 —— 先进后出 (LIFO)

## 语法

需要引入 `java.util.Stack` 包

```java
import java.util.Stack;
```

### 声明

```java
Stack <包装类> stack = new Stack<>();
```

### 常用方法

- push() —— 入栈
- pop() —— 出栈
- peek() —— 查看栈顶元素
- empty() —— 判断栈是否为空
- search() —— 查找元素在栈中的位置

## 代码示例

### 声明一个栈

```java
Stack <Integer> stack = new Stack<>();
```

### 检查栈是否为空

```java
System.out.println(stack.empty());
```

```
true
```

### 入栈

将 `1` 、 `2` 、 `3` 依次入栈

```java
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack.empty()); // 检查栈是否为空
System.out.println(stack); // 输出栈
```

```
false
[1, 2, 3]
```

### 出栈

将 `3` 出栈

```java
stack.pop();
System.out.println(stack); // 输出栈
```

```
[1, 2]
```

如果栈为空，再出栈会报错

```java
stack.pop();
stack.pop();
stack.pop();
```
```
Exception in thread "main" java.util.EmptyStackException
Exception in thread "main" java.util.EmptyStackException
        at java.base/java.util.Stack.peek(Stack.java:103)
        at java.base/java.util.Stack.pop(Stack.java:85)
        at stack.main(stack.java:21)
```

### 查看栈顶元素

```java
System.out.println(stack.peek());
```

```
2
```

### 查找元素在栈中的位置

```java
System.out.println(stack.search(1));
```

```
2
```