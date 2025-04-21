# 队列

## 定义

队列是一种**先进先出 (FIFO)** 的数据结构，队列中的元素只能从队尾插入，从队头删除。

- 入队 (Enqueue) —— 将元素添加到队尾
- 出队 (Dequeue) —— 将元素从队头删除

## 语法

需要导入 `java.util.Queue` 接口

```java
import java.util.Queue;
```

### 声明

```java
Queue <包装类> queue = new LinkedList<>();
```

### 常用方法

- add() —— 入队
- remove() —— 出队
- peek() —— 查看队头元素
- poll() —— 查看队头元素并删除
- isEmpty() —— 判断队列是否为空
- size() —— 查看队列长度
- contains() —— 判断队列中是否包含指定元素

## 代码示例

### 声明一个队列

**由于`Oueue`是一个接口，不能直接实例化，需要使用`LinkedList`类来实例化**

导入`java.util.LinkedList`包

```java
import java.util.LinkedList;
```

声明一个队列

```java
Queue <Integer> queue = new LinkedList<>();
```

### 检查队列是否为空

使用`Object.isEmpty()`方法检查队列是否为空

```java
System.out.println(queue.isEmpty());
```

```
true
```

### 入队

使用`Object.offer()`方法将元素添加到队尾

添加`1`、`2`、`3`到队列中

```java
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue);
```

```
[1, 2, 3]
```

也可以使用`Object.add()`方法将元素添加到队尾 (不推荐)，可能会抛出异常

### 出队

使用`Object.poll()`方法将元素从队头删除

```java
queue.poll();
System.out.println(queue);
```

```
[2, 3]
```

也可以使用`Object.remove()`方法将元素从队头删除 (不推荐)，可能会抛出异常

### 查看队头元素

使用`Object.peek()`方法查看队头元素

```java
System.out.println(queue.peek());
```

```
2
```

也可以使用`Object.element()`方法查看队头元素 (不推荐)，可能会抛出异常

### 查看队列长度

使用`Object.size()`方法查看队列长度

```java
System.out.println(queue.size());
```

```
2
```

### 查找元素在队列是否存在

使用`Object.contains()`方法查找元素在队列中是否存在

```java
System.out.println(queue.contains(2));
```

```
true
```