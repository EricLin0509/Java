# Super

## 定义

`super` 是 Java 中的关键字

- 表示父类的引用
- 用于构造函数或方法的重写
- 引用父类构造函数去初始化参数
- **如果父类的构造函数没有参数，则不需要使用 `super`**

## 示例

### 创建一个父类

```java
// Person.java

public class Person {
    
    String first;
    String last;

    Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    void showName() {
        System.out.println(first + " " + last);
    }

}
```

### 创建一个子类

```java
// Student.java

public class Student extends Person {
    
    double gpa;

    Student(String firstName, String lastName, double gpa) {
        this.first = firstName;
        this.last = lastName;
        this.gpa = gpa;
    }

}
```

这里会报错，显示 `Implicit super constructor Person() is undefined. Must explicitly invoke another constructor`，这是因为子类没有显式地调用父类的构造函数，因此需要在子类的构造函数中显式地调用父类的构造函数

#### 使用 super 显式调用父类的构造函数

```java
// Student.java

public class Student extends Person {
    
    double gpa;

    Student(String firstName, String lastName, double gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }

}
```

