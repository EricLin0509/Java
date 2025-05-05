# StringBuilder

## 简介

在 Java 中，字符串是不可变的，每次对字符串进行修改都会创建一个新的字符串对象。这种方式会导致内存的频繁分配和释放，影响程序的性能。为了避免这种情况，Java 提供了 StringBuilder 类，它是一个可变的字符串类，用于高效地拼接字符串


## 代码示例

### 创建 StringBuilder 对象

```java
StringBuilder sb = new StringBuilder();
```

### 追加字符串

```java
sb.append("Hello");
sb.append(" ");
sb.append("World");
```

### 插入字符串

```java
sb.insert(0, "Hello");
sb.insert(6, " ");
sb.insert(7, "World");
```

### 删除字符串

```java
sb.delete(0, 5);
sb.delete(5, 11);
```

### 替换字符串

```java
sb.replace(0, 5, "Hello");
sb.replace(6, 11, "World");
```

### 反转字符串

```java
sb.reverse();
```

### 获取字符串长度

```java
int length = sb.length();
```

### 获取字符串内容

```java
String str = sb.toString();
```