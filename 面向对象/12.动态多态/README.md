# 动态多态 (Runtime Polymorphism)

## 定义

动态多态是指在程序运行时根据实际的类型确定调用的方法，而不是在编译时确定

## 实现

### 创建父类

```java
// Animal.java

public abstract class Animal {
    
    abstract void speak();

}
```

### 创建子类

```java
// Dog.java

public class Dog extends Animal {
    
    @Override
    void speak() {
        System.out.println("Woof!");
    }

}
```

```java
// Cat.java

public class Cat extends Animal {
    
    @Override
    void speak() {
        System.out.println("Meow!");
    }

}
```

### 创建对象

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Animal animal = new Animal();

    }
}
```

虽说直接初始化 `Animal` 类会报错，但是我们可以使用抽象类创建一个未初始化的对象

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        
        Animal animal; // 使用抽象类创建一个未初始化的对象

    }
}
```

### 获取用户输入

```java
// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Animal animal; // 使用抽象类创建一个未初始化的对象

        System.out.println("Enter animal type (1: dog, 2: cat): ");

        int choice = scanner.nextInt();

        scanner.close();
    }
}
```

### 选择子类初始化对象

```java
// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Animal animal; // 使用抽象类创建一个未初始化的对象

        System.out.println("Enter animal type (1: dog, 2: cat): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            animal = new Dog(); // 初始化为 Dog 对象
            animal.speak();
        }
        else if (choice == 2) {
            animal = new Cat(); // 初始化为 Cat 对象
            animal.speak();
        }
        else {
            System.out.println("Invalid choice!");
        }

        scanner.close();

    }
}
```

### 运行结果

```
Enter animal type (1: dog, 2: cat):
1
Woof!

Enter animal type (1: dog, 2: cat):
2
Meow!
```

可以看到，根据用户的输入，程序可以动态地选择使用不同的子类来初始化对象，并调用相应的方法，这就是动态多态的实现