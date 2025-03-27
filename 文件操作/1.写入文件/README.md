# 写入文件

在Java中，有4种方法可以写数据到文件中：

- FileWriter —— 用于写入中小型文本文件
- BufferedWriter —— 性能更好，用于写入大型文本文件
- PrintWriter —— 用于写入结构化文本文件，如报告、LOG文件等
- FileOutputStream —— 用于写入二进制文件，如图片、视频等

**这里只介绍FileWriter**

## 实现

### 创建 `FileWriter` 对象

需要引入 `java.io.FileWriter` 类

```java
import java.io.FileWriter;
```

```java
FileWriter writer = new FileWriter("output.txt");
```

但可能出现无法写入的情况，需要捕获 `IOException` 异常

```java
import java.io.FileWriter;
import java.io.IOException;
```

```java
try (FileWriter writer = new FileWriter("output.txt")) {

}
catch (IOException e) {
    System.out.println("Can't write to file");
}
```

### 写入数据

使用 `write()` 方法写入数据

```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello World!");
    System.out.println("File written successfully");
}
catch (IOException e) {
    System.out.println("Can't write to file");
}
```

### 写入到指定路径

假设要写入到上级目录的output.txt文件中

**注意：斜杠是双斜杠 (转义字符)**

```java
try (FileWriter writer = new FileWriter("..//output.txt")) {
    writer.write("Hello World!");
    System.out.println("File written successfully");
}
catch (IOException e) {
    System.out.println("Can't write to file");
}
```

### 尝试传入不存在的路径

可以捕获 `FileNotFoundException` 异常

```java
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
```

```java
try (FileWriter writer = new FileWriter(".//haha//output.txt")) {
    writer.write("Hello World!");
    System.out.println("File written successfully");
}
catch (FileNotFoundException e) {
    System.out.println("File not found");
}
catch (IOException e) {
    System.out.println("Can't write to file");
}
```

```
File not found
```