# BufferedWriter

## 简介

BufferedWriter 是 Java 中用于写入字符流的缓冲类，它提供了缓冲功能，能够提高写入效率

## 构造方法

- `BufferedWriter(Writer out)`：创建一个使用默认大小输出缓冲区的缓冲字符输出流
- `BufferedWriter(Writer out, int sz)`：创建一个使用指定大小输出缓冲区的缓冲字符输出流

## 常用方法

- `write(int c)`：写入单个字符
- `write(char[] cbuf, int off, int len)`：写入字符数组的某一部分
- `write(String s, int off, int len)`：写入字符串的某一部分
- `newLine()`：写入一个行分隔符
- `flush()`：刷新该流的缓冲
- `close()`：关闭该流

## 代码示例

### 创建 BufferedWriter 对象

首先需要创建 `FileWriter` 对象 (用于传入文件路径)，然后将 `FileWriter` 对象传入 `BufferedWriter` 构造方法中

需要引入 `java.io.BufferedWriter` 和 `java.io.FileWriter` 类

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
```

```java
FileWriter fileWriter = new FileWriter("data.txt");
BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
```

或者

```java
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"));
```

此时会报错

```
Unhandled exception type IOException
```

这是因为 `BufferedWriter` 构造方法抛出了 `IOException` 异常，需要使用 `try-catch` 语句处理

```java
try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"))) {
    // 写入操作
}
catch (IOException e) {
    System.out.println("Cannot write to file");
}
```

### 写入字符
使用 `write()` 方法写入字符

```java
try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"))) {
    bufferedWriter.write("Hello World!");
}
catch (IOException e) {
    System.out.println("Cannot write to file");
}
```

此时会发出警告

```
Resource leak: 'bufferedWriter' is never closed
```

这是因为 `BufferedWriter` 没有被关闭，需要在 `try` 语句块结束后关闭

```java
try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"))) {
    bufferedWriter.write("Hello World!");
    bufferedWriter.close(); // 关闭 BufferedWriter
}
catch (IOException e) {
    System.out.println("Cannot write to file");
}
```

### 写入多行字符

如果直接使用 `write()` 方法写入多行字符

```java
bufferedWriter.write("Hello World!");
bufferedWriter.write("Hello World again!");
```

得到的结果是

```
Hello World!Hello World again!
```

这是因为 `write()` 方法不会自动添加换行符，需要使用 `newLine()` 方法添加换行符

```java
bufferedWriter.write("Hello World!");
bufferedWriter.newLine(); // 添加换行符
bufferedWriter.write("Hello World again!");
```

或者使用 `\n` 换行符

```java
bufferedWriter.write("Hello World!\n");
bufferedWriter.write("Hello World again!");
```

此时能得到正确的结果

```
Hello World!
Hello World again!
```

### 写入字符数组

使用 `write(char[] cbuf, int off, int len)` 方法写入字符数组的某一部分

```java
char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
bufferedWriter.write(chars, 0, 5); // 写入字符数组的前5个字符
```

此时得到的结果

```
Hello
```

### 写入字符串数组

使用增强 `for` 循环遍历字符串数组，然后使用 `write()` 方法写入字符串

```java
String[] names = {"Tom", "Jerry", "Spike", "Tyke"};
for (String name : names) {
    bufferedWriter.write(name);
    bufferedWriter.newLine(); // 添加换行符
}
```

此时得到的结果

```
Tom
Jerry
Spike
Tyke
```