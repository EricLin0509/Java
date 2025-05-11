# 多线程

## 定义

在Java中，线程是轻量级的进程，线程的创建和销毁的开销比进程小很多

## 语法

可以通过继承 `Thread` 类并重写 `run()` 方法来创建线程

```java
public class 类名 extends Thread {
    @Override
    public void run() {
        // 线程执行的代码
    }
}
```

也可以通过实现 `Runnable` 接口并重写 `run()` 方法来创建线程

```java
public class 类名 implements Runnable {
    @Override
    public void run() {
        // 线程执行的代码
    }
}
```

## 代码示例

### 创建 `myThread` 类

```java
// myThread.java

public class myThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("myThread: " + i);
            try {
                Thread.sleep(1000); // 休眠1秒
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

### 创建线程

```java
// main.java

public class main {
    public static void main(String[] args) {
        myThread thread = new myThread();
    }
}
```

### 启动线程

使用 `Object.start()` 方法启动线程

```java
// main.java

public class main {
    public static void main(String[] args) {
        myThread thread = new myThread();
        thread.start();
    }
}
```

### 启动多个线程

使用 `Object.start()` 方法启动多个线程

```java
// main.java

public class main {
    public static void main(String[] args) {
        myThread thread1 = new myThread();
        myThread thread2 = new myThread();
        thread1.start();
        thread2.start();
    }
}
```

```
1
1
2
2
3
3
4
4
5
5
```

使用 `Object.run()` 方法启动多个线程

```java
// main.java

public class main {
    public static void main(String[] args) {
        myThread thread1 = new myThread();
        myThread thread2 = new myThread();
        thread1.run();
        thread2.run();
    }
}
```

```
1
2
3
4
5
1
2
3
4
5
```

**注意：`Object.run()` 方法不会启动线程，而是在当前线程中执行 `run()` 方法，所以不会同时执行多个线程**

### 线程的无序性

线程的执行顺序是不确定的，这是因为线程的调度是由操作系统决定的

```java
//myThread.java

public class myThread extends Thread {
    private int id;
    public myThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from thread " + id);
        }
    }
}
```

```java
//main.java

public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            myThread thread = new myThread(i);
            thread.start();
        }
    }
}
```

```
Hello from thread 1
Hello from thread 2
Hello from thread 3
Hello from thread 2
Hello from thread 1
Hello from thread 2
Hello from thread 3
Hello from thread 2
Hello from thread 1
Hello from thread 2
Hello from thread 3
Hello from thread 1
Hello from thread 3
Hello from thread 1
Hello from thread 3
```

可以看到，线程的执行顺序是不确定的

### 线程的独立性

线程之间是独立的，它们之间的变量是不共享的，每个线程都有自己的栈空间

```java
//myThread.java

public class myThread extends Thread {
    private int id;
    public myThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        if (id == 3) {
            throw new RuntimeException("Thread 3");
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from thread " + id);
        }
    }
}
```

```
Exception in thread "Thread-2" java.lang.RuntimeException: Thread 3
        at myThread.run(myThread.java:9)
Hello from thread 2
Hello from thread 2
Hello from thread 2
Hello from thread 2
Hello from thread 2
Hello from thread 1
Hello from thread 1
Hello from thread 1
Hello from thread 1
Hello from thread 1
```

可以看到，即使线程 3 抛出了异常，其他线程仍然可以正常执行


### 实现 `Runnable` 接口

**实现 `Runnable` 接口可以避免单继承的限制，同时也可以共享资源**

```java
//myThread.java

public class myThread implements Runnable {
    private int id;
    public myThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from thread " + id);
        }
    }
}
```

```java
//main.java

public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            myThread mythings = new myThread(i);
            Thread thread = new Thread(mythings); // 需要将 Runnable 对象传递给 Thread 构造函数
            thread.start();
        }
    }
}
```

### 等待线程执行完成

使用 `Object.join()` 方法等待线程执行完成

```java
//main.java

public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            myThread thread = new myThread(i);
            thread.start();
            try {
                thread.join(); // 等待线程执行完成
                System.out.println("Thread " + i + " finished");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

### 检查线程是否活跃

使用 `Object.isAlive()` 方法检查线程是否活跃

```java
//main.java

public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            myThread thread = new myThread(i);
            thread.start();
            while (thread.isAlive()) {
                System.out.println("Thread " + i + " is alive");
            }
        }
    }
}
```