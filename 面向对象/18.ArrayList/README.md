# ArrayList

## 定义

- 一种可以改变大小的数组，支持自动装箱
- 用于存储和操作对象的元素的线性集合
- **相比于普通数组，ArrayList 的大小可以动态改变**

## 代码示例

### 初始化

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // 创建一个 ArrayList 对象
    }
}
```

### 设置存储类型

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer
    }
}
```

### 添加元素

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3
    }
}
```

### 删除元素
```java
```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        list.remove(1); // 删除索引为 1 的元素
    }
}
```

### 输出元素

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        System.out.println(list); // 输出 ArrayList 对象
    }
}
```

```
[1, 2, 3]
```

### 替换元素

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        System.out.println(list); // 输出 ArrayList 对象

        list.set(1, 4); // 将索引为 1 的元素替换为 4
        System.out.println(list); // 输出 ArrayList 对象
    }
}
```

```
[1, 2, 3]
[1, 4, 3]
```

### 获取元素

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        System.out.println(list.get(1)); // 获取索引为 1 的元素
    }
}
```

```
2
```

### 获取长度

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        System.out.println(list.size()); // 获取 ArrayList 的长度
    }
}
```

```
3
```

### 排序

需要导入 `java.util.Collections` 类

```java
import java.util.ArrayList; // 导入 ArrayList 类
import java.util.Collections; // 导入 Collections 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(3); // 添加元素 3
        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2

        System.out.println(list); // 输出 ArrayList 对象

        Collections.sort(list); // 对 ArrayList 进行排序
        System.out.println(list); // 输出 ArrayList 对象
    }
}
```

```
[3, 1, 2]
[1, 2, 3]
```

### 遍历

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        for (int num : list) {
            System.out.println(num); // 遍历 ArrayList 对象
        }
    }
}
```

或者

```java
import java.util.ArrayList; // 导入 ArrayList 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // 遍历 ArrayList 对象
        }
    }
}
```

```
1
2
3
```