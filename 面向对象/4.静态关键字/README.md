# 静态

## 定义

- 使变量/方法归属于类，而不属于对象
- 通常用于共享资源或实用方法

## 代码示例

## 静态变量

### 不使用 static 关键字

```java
// test.java

public class test {
    String name;
    int num = 0;

    test (String name) {
        this.name = name;
        num++;
    }
}
```

```java
// Main.java
public class Main {
    public static void main(String[] args) {

        test name1 = new test("John");

        System.out.println(name1.num);

        test name2 = new test("Jane");

        System.out.println(name2.num);
    }
}
```

#### 输出

```bash
1
1
```

#### 原因

每次实例化对象时，num 都会被重置为 0

### 使用 static 关键字

```java
// test.java

public class test {
    String name;
    static int num = 0;

    test (String name) {
        this.name = name;
        num++;
    }
}
```

#### 输出
```bash
1
2
```

此时会弹出警告

```
The static field num should be accessed in a static way
```

这是因为 num 是静态变量，所以需要使用静态方法来访问

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        test name1 = new test("John");
        System.out.println(test.num); // 使用静态方法访问
        
        test name2 = new test("Jane");
        System.out.println(test.num); // 使用静态方法访问
    }
}
```

## 静态方法

```java
// test.java

static void show_num() {
    System.out.println(num);
}
```

调用方法

```java
// Main.java

test.show_num();
```

可以看到，静态方法不需要实例化对象就可以调用

### 输出

```bash
2
```