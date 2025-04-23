# 上转型与下转型对象

## 定义

- 上转型对象 (Upcasting)：**<mark>子类对象</mark>赋值给<mark>父类引用</mark>**
- 下转型对象(Downcasting)：**<mark>父类对象</mark>赋值给<mark>子类引用</mark>**

## 代码示例

### 创建父类

```java
// Animal.java

public class Animal {

    public void eat() {
        System.out.println("The animal is eating.");
    }

}
```

### 创建子类
```java
// Dog.java

public class Dog extends Animal {
    
    public void bark() {
        System.out.println("The dog is barking.");
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating.");
    }
}
```

```java
// Cat.java

public class Cat extends Animal {

    public void meow() {
        System.out.println("The cat is meowing.");
    }
    
    @Override
    public void eat() {
        System.out.println("The cat is eating.");
    }
}
```

### 上转型对象

使用 `Dog` 子类实例化 `Animal` 父类

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // 上转型对象
    }
}
```

### 调用方法

#### 调用 `eat()` 方法

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
    }
}
```

```
The dog is eating.
```

可以看到，**上转型对象调用的是子类重写的方法**

#### 调用 `bark()` 方法

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.bark();
    }
}
```

这时候会报错：

```
The method bark() is undefined for the type Animal
```

这是因为 `bark()` 方法是 `Dog` 子类特有的方法，而 `Animal` 父类并没有这个方法

### 应用示例

可以创建一个方法，接收一个 `Animal` 类型的参数，然后调用 `eat()` 方法

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        feed(animal);
        Dog dog = new Dog();
        feed(dog);
    }

    public static void feed(Animal animal) {
        animal.eat();
    }
}
```

```
The dog is eating.
The dog is eating.
```

可以看到，**这个方法可以接收 `Animal` 类型的参数，也可以接收 `Dog` 类型的参数**

### 下转型对象

使用 `Animal` 父类实例化 `Dog` 子类

**注意：下转型对象需要强制转换，且只能转换为子类类型**

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }

    public static void feed(Animal animal) {
        Dog dog = (Dog) animal; // 下转型对象
        dog.bark();
    }
}
```

### 尝试 `Dog` 下转型至 `Animal` 父类

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = (Dog) animal; // 下转型对象
    }
}
```
这时候会报错：

```
Exception in thread "main" java.lang.ClassCastException: class Animal cannot be cast to class Dog (Animal and Dog are in unnamed module of loader 'app')
```

这是因为 `Animal` 不是 `Dog` 的子类，所以不能进行下转型

### 尝试 `Cat` 下转型至 `Dog` 子类

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
    }

    public static void feed(Animal animal) {
        Dog dog = (Dog) animal; // 下转型对象
        dog.bark();
    }
}
```

此时会报错：

```
Exception in thread "main" java.lang.ClassCastException: class Cat cannot be cast to class Dog (Cat and Dog are in unnamed module of loader 'app')
```

这是因为 `Dog` 和 `Cat` 都是 `Animal` 的子类，但是 `Dog` 不是 `Cat` 的子类，所以不能进行下转型

### 解决方法

使用 `instanceof` 关键字判断对象是否是指定类型

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
    }

    public static void feed(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // 下转型对象
            dog.bark();
        }
    }
}
```