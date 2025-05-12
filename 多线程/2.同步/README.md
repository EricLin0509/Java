# 多线程同步

## 定义

在Java中，多线程同步是指多个线程在访问共享资源时，通过一定的机制来保证线程的安全性和数据的一致性

## 语法

```java
public synchronized void method() {
    // 代码块
}
```

或者

```java
synchronized (object) {
    // 代码块
}
```

- `synchronized` 关键字用于修饰方法或代码块
- 当一个线程进入 `synchronized` 方法或代码块时，其他线程将被阻塞，直到当前线程执行完毕
- 可以使用 `synchronized` 关键字来修饰方法或代码块，以确保在同一时间只有一个线程可以访问共享资源

## 代码示例

### 设计多线程

```java
// Mydata.java

public class Mydata {
    private int num = 0;

    public void add() {
        num++;
    }

    public int getNum() {
        return num;
    }
}
```

```java
// MyThread.java

public class MyThread extends Thread {
    Mydata mydata; // 增加共享变量
    
    // 添加构造函数
    public MyThread(Mydata mydata) {
        this.mydata = mydata;
    }

    @Override
    public void run() {
        // 移除局部变量 mydata = new Mydata();
        for (int i = 0; i < 10000; i++) {
            mydata.add();
        }
    }
}
```

```java
// main.java

public class main {
    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        Thread[] threads = new Thread[10]; // 保存线程引用
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new MyThread(mydata); // 传递共享对象
            threads[i].start();
        }
        
        // 等待所有线程完成
        for (Thread t : threads) {
            try {
                t.join(); // 等待线程完成
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(mydata.getNum());
    }
}
```

这个预期结果是100000

但是实际结果是：

```
96115
```

这是因为出现了竞态条件（Race Condition），多个线程同时对共享变量进行修改，导致结果不正确

#### 原因

[传送门](https://github.com/EricLin0509/C/blob/main/%E7%BA%BF%E7%A8%8B/3.%E7%AB%9E%E6%80%81%E6%9D%A1%E4%BB%B6/README.md#%E5%8E%9F%E5%9B%A0)

### 解决竞态条件

使用 `synchronized` 关键字来解决竞态条件

```java
// Mydata.java

public class Mydata {
    private int num = 0;

    public synchronized void add() { // 添加 synchronized 关键字
        num++;
    }

    public int getNum() {
        return num;
    }
}
```

或者

```java
// Mydata.java

public class Mydata {
    private int num = 0;

    public void add() {
        synchronized (this) { // 使用 synchronized 关键字修饰代码块
            num++;
        }
    }

    public int getNum() {
        return num;
    }
}
```

现在的结果是：

```
100000
```