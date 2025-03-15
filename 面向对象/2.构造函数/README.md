# 构造函数 (Constructor)

## 定义

构造函数是一种特殊的方法，用于初始化对象的成员变量

## 特点

- 构造函数的名称必须与类名相同
- 构造函数没有返回值
- 构造函数可以有参数
- 构造函数可以重载
- 构造函数可以在构建对象时自动调用

## 代码示例

### 创建构造函数并调用

```java
// Students.java

public class Students {

    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    Students() { // 构造函数
        
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Students students1 = new Students(); // 调用构造函数
        System.out.println(students1.name);

    }
}
```

### 传递参数给构造函数

```java
// Students.java

public class Students {

    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    Students(String name, int age, double gpa) { // 构造函数
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
}
```

`this` 是一个关键字，用于引用当前对象的成员变量

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Students students1 = new Students("John", 19, 3.5); // 调用构造函数
        System.out.println(students1.name);
        System.out.println(students1.age);
        System.out.println(students1.gpa);

        Students students2 = new Students("Jane", 20, 3.0); // 调用构造函数
        System.out.println(students2.name);
        System.out.println(students2.age);
        System.out.println(students2.gpa);

    }
}
```

此处 `this` 指向 `students1` 或 `students2` 

#### 运行

```bash
John
19
3.5
Jane
20
3.0
```

### 在构建器初始化成员变量

```java
// Students.java

public class Students {

    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    Students(String name, int age, double gpa) { // 构造函数
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true;
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Students students1 = new Students("John", 19, 3.5); // 调用构造函数
        System.out.println(students1.isEnrolled);

        Students students2 = new Students("Jane", 20, 3.0); // 调用构造函数
        System.out.println(students2.isEnrolled);

    }
}
```

#### 运行
```bash
true
true
```

### 在类中创建方法

```java
// Students.java

public class Students {

    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    Students(String name, int age, double gpa) { // 构造函数
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true;
    }

    void enroll() {
        System.out.println(this.name + " is enrolled.");
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Students students1 = new Students("John", 19, 3.5); // 调用构造函数
        students1.enroll(); // 调用 Students 类中的 enroll 方法

        Students students2 = new Students("Jane", 20, 3.0); // 调用构造函数
        students2.enroll(); // 调用 Students 类中的 enroll 方法

    }
}
```

#### 运行
```bash
John is enrolled
Jane is enrolled
```