# 读取文件

在Java中，有 3 种读取文件的方式：

- BufferedReader & FileReader —— 用于一行一行读取文本文件
- FileInputStream —— 用于读取二进制文件 (如图片、视频等)
- RandomAccessFile —— 用于读取/写入部分数据到大文件中

**这里只介绍 BufferedReader & FileReader**

## 代码实现

### 设置文件路径

```java
public class ReadFile {
	public static void main(String[] args) {
	
        String filePath = "data.txt";

	}
}
```

### 创建 `BufferedReader` 对象

需要引入 `java.io.BufferedReader` 和 `java.io.FileReader` 类

```java
import java.io.BufferedReader;
import java.io.FileReader;
```

```java
public class ReadFile {
	public static void main(String[] args) {
	
        String filePath = "data.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

	}
}
```

此时，会发生报错

```
Unhandled exception type FileNotFoundException
```

这是因为对文件操作是需要捕获异常的，所以需要使用 `try...catch` 语句

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
```

```java
public class ReadFile {
	public static void main(String[] args) {
	
        String filePath = "data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	
        }
        catch (FileNotFoundException e) {
        	System.out.println("File not found");
        }
        catch (IOException e) {
        	System.out.println("Error reading file");
        }

	}
}
```

### 读取文件

我们可以使用 `readLine()` 方法来读取文件中的每一行

**当读取到文件末尾时，`readLine()` 方法会返回 `null`**

```java
public class ReadFile {
	public static void main(String[] args) {
	
        String filePath = "data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	String line;
        	while ((line = reader.readLine()) != null) {
        		System.out.println(line);
        	}
        }
        catch (FileNotFoundException e) {
        	System.out.println("File not found");
        }
        catch (IOException e) {
        	System.out.println("Error reading file");
        }

	}
}
```