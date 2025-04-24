# 内部类 (Inner Class)

## 定义

在Java中，允许在类的内部定义类

## 语法

```java
class Outer {
    class Inner {
        // ...
    }
}
```

## 代码示例

### 创建内部类

```java
//Outer.java

public class Outer {
    int num = 10;
    public void show() {
        System.out.println(num);
    }

    public class Inner {
        
    }
}
```

### 在内部类中创建成员变量和方法

在内部类中，也可以创建成员变量和方法

```java
//Outer.java

public class Outer {
    int num = 10;
    public void show() {
        System.out.println(num);
    }

    public class Inner {
        int num = 20;
        public void show() {
            System.out.println(num);
        }
    }
}
```

### 创建内部类对象

```java
//main.java
public class Main {
    public static void main(String[] args) {
        Inner inner = new Inner();
    }
}
```

此时会报错，因为内部类是在外部类中定义的，所以需要先创建外部类对象，然后再创建内部类对象

```java
//main.java

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
```

或者

```java
//main.java

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}
```

但是如果遇到**只创建内部类对象的情况，还是需要先创建外部类对象的**，这时可以使用静态内部类

### 静态内部类

静态内部类是在内部类前加上static关键字

这样就可以直接创建静态内部类对象了

```java
//Outer.java

public class Outer {
    int num = 10;
    public void show() {
        System.out.println(num);
    }

    public static class StaticInner {
        int num = 30;
        public void show() {
            System.out.println(num);
        }
    }
}
```

```java
//main.java

public class Main {
    public static void main(String[] args) {
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.show();
    }
}
```

### 本地内部类

本地内部类是在方法中定义的内部类

可以在非静态方法和静态方法中创建本地内部类对象

```java
//Outer.java
public class Outer {
    int num = 10;
    public void show() {
        System.out.println(num);
    }

    public void method() { // 非静态方法
        class LocalInner {
            int num = 20;
            public void show() {
                System.out.println(num);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.show();
    }

    public static void method2() { // 静态方法
        class LocalInner {
            int num = 20;
            public void show() {
                System.out.println(num);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.show();
    }
}
```