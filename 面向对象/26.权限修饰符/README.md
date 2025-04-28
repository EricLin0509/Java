# 权限修饰符

## 定义

在Java中，可以使用访问修饰符来控制类、方法和变量的访问权限。Java提供了四个访问修饰符：

- `public` —— 公共的，对所有类可见
- `protected` —— 受保护的，对同一包中的类和子类可见
- `default` —— 默认的，对同一包中的类可见
- `private` —— 私有的，只能在同一类中访问

## 代码示例

### default

`default` 修饰符是默认的，它可以省略不写。如果一个类、方法或变量没有使用任何访问修饰符，那么它就是默认的

```java
//C.java

package.package2;
import package1.*;

public class C {
    String s = "This is default"; // 默认的
}
```

尝试在另一个包中访问 `s` 会报错

```java
//A.java

package package1;
import package2.*;

public class A {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s);
    }
}
```

```
C.s is not visible
```

这是因为 `s` 是默认的，**只能在同一包中访问**

```java
// D.java

package package2;
import package1.*;

public class D {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s);
    }
}
```

在同一个包中访问 `s` 不会报错

```
This is default
```

### public

`public` 修饰符是公共的，它可以对所有类可见

```java
// C.java

package package2;
import package1.*;

public class C {
    public String s = "This is public"; // 公共的
}
```

在同一个包中访问 `s` 不会报错

```java
//A.java

package package1;
import package2.*;

public class A {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s);
    }
}
```

```
This is public
```

### protected

`protected` 修饰符是受保护的，它可以对同一包中的类和子类可见

```java
// B.java

package package1;
import package2.*;

public class B {
    protected String s = "This is protected"; // 受保护的
}
```

在子类中访问 `s` 不会报错

```java
// D.java

package package2;
import package1.*;

public class D extends B {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.s);
    }
}
```

```
This is protected
```

在同一个包中访问 `s` 不会报错

```java
//A.java

package package1;
import package2.*;

public class A {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.s);
    }
}
```

```
This is protected
```

### private

`private` 修饰符是私有的，它只能在同一类中访问

```java
// C.java
package package2;
import package1.*;

public class C {
    private String s = "This is private"; // 私有的
}
```

在同一个包中访问 `s` 会报错

```java
//D.java
package package2;
import package1.*;

public class D {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s);
    }
}
```

```
C.s is not visible
```

在同一个类中访问 `s` 不会报错

```java
//C.java
package package2;
import package1.*;

public class C {
    private String s = "This is private"; // 私有的
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s);
    }
}
```

```
This is private
```

## 总结

- `public` 修饰符是公共的，它可以对所有类可见
- `protected` 修饰符是受保护的，它可以对同一包中的类和子类可见
- `default` 修饰符是默认的，它可以对同一包中的类可见
- `private` 修饰符是私有的，它只能在同一类中访问