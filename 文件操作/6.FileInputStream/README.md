# FileInputStream

## 简介

`FileInputStream` 是 Java 中用于读取文件内容的输入流类。它允许程序从文件中读取字节数据，并将其转换为字符流或字节流进行处理

## 构造方法

- `FileInputStream(File file)`：通过 `File` 对象创建一个 `FileInputStream` 对象

- `FileInputStream(String name)`：通过文件路径创建一个 `FileInputStream` 对象

## 代码示例

需要导入 `java.io.FileInputStream` 类

```java
import java.io.FileInputStream;
```

### 创建 `FileInputStream` 对象

在创建 `FileInputStream` 对象时，需要先创建一个 `File` 对象，然后将其作为参数传递给构造方法

```java
File file = new File("data.txt");
FileInputStream input = new FileInputStream(file);
```

或者

```java
FileInputStream input = new FileInputStream(new File("data.txt"));
```

此时会报错

```
Unhandled exception type FileNotFoundException
```

这是因为 `FileInputStream` 构造方法会抛出 `FileNotFoundException` 异常，因此需要使用 `try-catch` 块来捕获异常

```java
try {
    FileInputStream input = new FileInputStream(new File("data.txt"));
}
catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```

此时会弹出警告

```
Resource leak: 'input' is never closed
```

这是因为 `FileInputStream` 是一个输入流，需要在使用完后关闭

### 关闭 `FileInputStream` 对象

在使用完 `FileInputStream` 对象后，需要调用 `close()` 方法来关闭输入流

**需要捕捉 `IOException` 异常**

```java
try {
    ...
    input.close();
}
catch (IOException e) {
    e.printStackTrace();
}
```

### 读取文件内容

使用 `read()` 方法可以从输入流中读取一个字节的数据，并将其**转换为 `int` 类型的数值**

**如果到达文件末尾，则返回 `-1`**

```java
int i;
char c;
while ((i = input.read()) != -1) {
    c = (char) i;
    System.out.print(c);
}
```

### 与 `Scanner` 类结合使用

可以使用 `Scanner` 类来读取文件内容

```java
FileInputStream input = new FileInputStream(new File("data.txt"));
Scanner scanner = new Scanner(input);
scanner.close();
input.close();
```

### 读取字符串

使用 `hasNextLine()` 方法可以判断是否还有下一个字符串

使用 `nextLine()` 方法可以读取下一个字符串

```java
FileInputStream input = new FileInputStream(new File("data.txt"));
Scanner scanner = new Scanner(input);
while (scanner.hasNextLine()) {
    System.out.println(scanner.nextLine());
}
scanner.close();
input.close();
```