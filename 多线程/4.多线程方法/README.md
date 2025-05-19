# 多线程方法

在 Java 中，有以下几种常见的多线程方法：

- Thread.sleep()：使当前线程暂停执行指定的时间

- Thread.join()：等待当前线程执行完毕

- Thread.yield()：让当前线程放弃 CPU 资源，让其他线程执行

- Thread.setDaemon()：将当前线程设置为守护线程，当所有非守护线程执行完毕时，守护线程会自动终止

- Thread.start()：启动一个新线程

- Thread.stop()：停止当前线程的执行 (已被弃用)

## 代码示例

### Thread.sleep()

`Thread.sleep()` 方法可以使当前线程暂停执行指定的时间

例如暂停 1 秒：

```java
Thread.sleep(1000);
```

```java
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " Start");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " Finished");
        };
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
```

这里先输出 `Thread-0 Start`，然后暂停 2 秒，再输出 `Thread-0 Finished`

### Thread.setDaemon()

`Thread.setDaemon()` 方法可以将当前线程设置为守护线程，当所有非守护线程执行完毕时，守护线程会自动终止

```java
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(name + " Running");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Thread-0 Running
Thread-0 Running
Thread-0 Running
```

可以看到，当主线程执行完毕后，守护线程也自动终止

### Thread.join()

`Thread.join()` 方法可以等待当前线程执行完毕

例如等待线程执行完毕后再执行主线程：

```java
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " Start");
        }
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Finished");
    }
}
```

```
Thread-0 Start
Main Finished
```

可以看到，主线程等待线程执行完毕后再执行