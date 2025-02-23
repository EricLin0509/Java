# 构造器重载

## 定义

构造器重载是指在一个类中定义多个构造器，以便根据不同的参数类型和数量来创建对象

## 代码示例

```java
// Users.java

public class Users {
    
    String username;
    String email;
    int age;

    Users(String username) {
        this.username = username;
    }

    Users(String username, String email) { // 构造器重载
        this.username = username;
        this.email = email;
    }

    Users(String username, String email, int age) { // 构造器重载
        this.username = username;
        this.email = email;
        this.age = age;
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Users user1 = new Users("James");
        System.out.println(user1.username);

        Users user2 = new Users("John", "john123@gmail.com");
        System.out.println(user2.username);
        System.out.println(user2.email);

        Users user3 = new Users("Jane", "jane456@outlook.com", 20);
        System.out.println(user3.username);
        System.out.println(user3.email);
        System.out.println(user3.age);
    }
}
```

## 运行结果

```bash
James
John
john123@gmail.com
Jane
jane456@outlook.com
20
```