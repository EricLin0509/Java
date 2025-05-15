# 设置或读取线程名

在Java中，线程的名称是一个字符串，用于标识线程的身份。可以使用`Thread`类的`setName()`方法来设置线程的名称，使用`getName()`方法来获取线程的名称

## 代码示例

### getName()

```java
// myThread.java

public class myThread extends Thread {
    public void run() {
        // 获取当前线程的名称
        String threadName = Thread.currentThread().getName();
        System.out.println("当前线程的名称为：" + threadName);
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        // 创建线程对象
        myThread thread = new myThread();
        // 启动线程
        thread.start();
    }
}
```

```
当前线程的名称为：Thread-0
```

### setName()

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        // Lambda表达式创建线程对象
        Runnable runnable = () -> {
            // 获取当前线程的名称
            String threadName = Thread.currentThread().getName();
            System.out.println("当前线程的名称为：" + threadName);
        }
        // 创建线程对象
        Thread thread = new Thread(runnable);
        // 设置线程的名称
        thread.setName("MyThread");
        // 启动线程
        thread.start();
    }
}
```

```
当前线程的名称为：MyThread
```