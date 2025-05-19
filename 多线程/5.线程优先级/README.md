# 线程优先级

## 定义

在 Java 中，线程的优先级是一个整数，范围从 1 到 10，其中 1 是最低优先级，10 是最高优先级

## 方法

- `Thread.setPriority(int)`：设置线程的优先级
- `Thread.getPriority()`：获取线程的优先级

## 代码示例

### 获取当前线程的优先级

```java
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        System.out.println("Thread-1 priority: " + thread1.getPriority());
        System.out.println("Thread-2 priority: " + thread2.getPriority());

        thread1.start();
        thread2.start();
    }
}
```

```
Thread-1 priority: 5
Thread-2 priority: 5
Thread-1 is running
Thread-2 is running
Thread-1 is running
Thread-1 is running
Thread-2 is running
Thread-1 is running
Thread-2 is running
Thread-1 is running
Thread-2 is running
Thread-2 is running
```

可以看到，线程的优先级是默认的 5

### 设置线程的优先级

一共有 10 个优先级，分别是：
- `Thread.MIN_PRIORITY`：最低优先级，值为 1
- `Thread.NORM_PRIORITY`：默认优先级，值为 5
- `Thread.MAX_PRIORITY`：最高优先级，值为 10
- 整数值：1-10

```java
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        
        thread1.start();
        thread2.start();
    }
}
```

```
Thread-2 is running
Thread-2 is running
Thread-2 is running
Thread-2 is running
Thread-2 is running
Thread-1 is running
Thread-1 is running
Thread-1 is running
Thread-1 is running
Thread-1 is running
```

可以看到，JVM 会偏向执行优先级高的线程