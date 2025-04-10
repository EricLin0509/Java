# Super

## 定义

`super` 是 Java 中的关键字

- 表示父类的引用
- 用于构造函数或方法的重写
- 引用父类构造函数去初始化参数
- **如果父类的构造函数没有参数，则不需要使用 `super`**

`super` 有以下用法

- 调用父类的构造函数
- 调用父类的方法

**注意：`super` 只能在子类中使用且只能在非静态方法中使用**

## 代码示例

## 调用父类的构造函数

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

## 调用父类的方法

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

```java
// Student.java

public class Student extends Person {
    double gpa;
    Student(String firstName, String lastName, double gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }

    @Override
    void showName() {
        super.showName();
    }
}
```

可以看到，即使子类重写了父类的方法，也可以使用 `super` 来调用父类的方法

