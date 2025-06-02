# BufferedReader

## 简介

BufferedReader 是 Java 标准库中的一个类，用于从字符输入流中读取文本数据。它提供了缓冲功能，能够提高读取效率

## 构造方法

- `BufferedReader(Reader in)`：创建一个 BufferedReader 对象，使用指定的字符输入流作为数据源

## 常用方法

- `read()`：读取单个字符并返回其 ASCII 码值，如果到达流的末尾，则返回 -1
- `read(char[] cbuf)`：将字符读入数组 cbuf 中，并返回实际读取的字符数，如果到达流的末尾，则返回 -1
- `readLine()`：读取一行文本并返回其字符串表示，如果到达流的末尾，则返回 null

## 代码示例

### 创建 BufferedReader 对象

首先需要创建 `FileReader` 对象 (用于传入文件路径)，然后将 `FileReader` 对象传入 `BufferedReader` 构造方法中

需要引入 `java.io.BufferedReader` 和 `java.io.FileReader` 类

```java
import java.io.BufferedReader;
import java.io.FileReader;
```

```java
FileReader fileReader = new FileReader("data.txt");
BufferedReader bufferedReader = new BufferedReader(fileReader);
```

或者

```java
BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
```

此时会报错

```
Unhandled exception type IOException
```

这是因为 `BufferedReader` 构造方法抛出了 `IOException` 异常，需要使用 `try-catch` 语句处理

```java
try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
    // 读取操作
}
catch (IOException e) {
    System.out.println("Cannot read file");
}
```

### 读取一行文本

使用 `readLine()` 方法读取一行文本并返回其字符串表示，如果到达流的末尾，则返回 null

```java
try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
    System.out.println(bufferedReader.readLine()); // 读取第一行文本
}
catch (IOException e) {
    System.out.println("Cannot read file");
}
```

此时会发出警告

```
Resource leak: 'bufferedReader' is never closed
```

这是因为 `BufferedReader` 对象没有被关闭，需要使用 `close()` 方法关闭

```java
try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
    System.out.println(bufferedReader.readLine()); // 读取第一行文本
    bufferedReader.close(); // 关闭 BufferedReader 对象
}
catch (IOException e) {
    System.out.println("Cannot read file");
}
```

### 读取多行文本

可以使用循环读取多行文本

由于 `readLine()` 读取到文件末尾会返回 null，因此循环的结束条件为 `line == null`

```java
try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
    String line; // 保存读取到的文本
    while ((line = bufferedReader.readLine()) != null) { // 读取到文件末尾时返回 null
        System.out.println(line); // 输出读取到的文本
    }
    bufferedReader.close(); // 关闭 BufferedReader 对象
}
catch (IOException e) {
    System.out.println("Cannot read file");
}
```