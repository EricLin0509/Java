# FileOutputStream

## 简介

FileOutputStream 是 Java 中用于将数据写入文件的输出流。它提供了一种将数据写入文件的方法，可以用于创建新文件、追加数据到现有文件或覆盖现有文件的内容

## 构造方法

- `FileOutputStream(File file)`：创建一个新的 FileOutputStream，指定要写入的文件

- `FileOutputStream(File file, boolean append)`：创建一个新的 FileOutputStream，指定要写入的文件和写入模式

- `FileOutputStream(String name)`：创建一个新的 FileOutputStream，指定要写入的文件路径

- `FileOutputStream(String name, boolean append)`：创建一个新的 FileOutputStream，指定要写入的文件路径和写入模式

## 代码示例

需要导入 `java.io.FileOutputStream` 类

```java
import java.io.FileOutputStream;
```

### 创建 `FileOutputStream` 对象

创建一个新的 `FileOutputStream` 对象，需要**先创建一个 `File` 对象**，然后将其传递给 `FileOutputStream` 的构造方法

```java
File file = new File("data.txt");
FileOutputStream output = new FileOutputStream(file);
```

或者

```java
FileOutputStream output = new FileOutputStream(new File("data.txt"));
```

此时会报错

```
Unhandled exception type FileNotFoundException
```

这是因为 `FileOutputStream` 的构造方法会抛出 `FileNotFoundException` 异常，需要使用 `try-catch` 块来捕获异常

```java
try {
    FileOutputStream output = new FileOutputStream(new File("data.txt"));
}
catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```

此时会弹出警告

```
Resource leak: 'output' is never closed
```

这是因为 `FileOutputStream` 对象没有被关闭，需要在 `try-catch` 块之外关闭 `FileOutputStream` 对象

### 关闭 `FileOutputStream` 对象

使用 `close()` 方法关闭 `FileOutputStream` 对象

**需要捕捉 `IOException` 异常**

```java
try {
    ...
    output.close();
}
catch (IOException e) {
    e.printStackTrace();
}
```

### 写入数据

假设现在有一个字符串 `data`，需要将其写入文件中

```java
String data = "Hello World!";
```

但是，`FileOutputStream` 的 `write()` 方法**只能写入字节数组，所以需要将字符串转换为字节数组**

使用 `getBytes()` 方法将字符串转换为字节数组

```java
byte[] bytes = data.getBytes();
```

然后，使用 `write` 方法将字节数组写入文件

**需要捕捉 `IOException` 异常**

```java
try {
    ...
    output.write(bytes);
}
catch (IOException e) {
    System.out.println("Error writing to file");
}
```

## PrintStream

`PrintStream` 是 Java 中用于格式化输出的类，它提供了一种将数据写入文件的方法，可以用于创建新文件、追加数据到现有文件或覆盖现有文件的内容

需要导入 `java.io.PrintStream` 类

```java
import java.io.PrintStream;
```

### 创建 `PrintStream` 对象

创建一个新的 `PrintStream` 对象，需要**先创建一个 `FileOutputStream` 对象**，然后将其传递给 `PrintStream` 的构造方法

**需要捕捉 `FileNotFoundException` 异常**

```java
try {
    FileOutputStream output = new FileOutputStream(new File("data.txt"));
    PrintStream printOut = new PrintStream(output);
}
catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```

此时会弹出警告
```
Resource leak: 'printOut' is never closed
```

这是因为 `PrintStream` 对象没有被关闭，需要在 `try-catch` 块之外关闭 `PrintStream` 对象

### 关闭 `PrintStream` 对象

使用 `close()` 方法关闭 `PrintStream` 对象

**需要捕捉 `IOException` 异常**

```java
try {
   ...
    printOut.close();
}
catch (IOException e) {
    e.printStackTrace();
}
```

### 写入一行数据

使用 `println()` 方法写入一行数据

**需要捕捉 `IOException` 异常**

```java
try {
    printOut.println("Hello World!");
}
catch (IOException e) {
    System.out.println("Error writing to file");
}
```

### 刷新缓冲区

使用 `flush()` 方法刷新缓冲区，一般情况下，缓冲区会在写入数据时自动刷新，但是如果需要立即写入数据，可以使用 `flush()` 方法

**需要捕捉 `IOException` 异常**

```java
try {
    printOut.flush();
}
catch (IOException e) {
    System.out.println("Error flushing buffer");
}
```