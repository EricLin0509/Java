# 发送信号

## 简介

在Java多线程编程中，线程之间的通信是一个重要的概念。Java提供了多种机制来实现线程之间的通信，其中最常用的是使用wait()和notify()方法来实现线程的等待和通知

- `wait()` —— 使当前线程等待，直到其他线程调用`notify()`或`notifyAll()`方法来唤醒它
- `notify()` —— 唤醒一个正在等待的线程
- `notifyAll()` —— 唤醒所有正在等待的线程

**注意：使用发送信号的方式实现线程之间的通信，需要在同步代码块 (`synchronized`) 中使用，否则会抛出`IllegalMonitorStateException`异常**

## 代码示例

### `wait()`和`notify()`

```java
public class Signaling {
    public static void main(String[] args) {
        Thread waiting = new Thread(() -> {
            synchronized (Signaling.class) {
                try {
                    System.out.println("Waiting...");
                    Signaling.class.wait();
                    System.out.println("Notified!");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waiting.start();

        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                try {
                    Thread.sleep(1000); // 等待1秒
                    System.out.println("Notifying...");
                    Signaling.class.notify();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        signaling.start();

        try { // 等待线程结束
            waiting.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Waiting...
Notifying...
Notified!
```

可以看到，在等待1秒后，`signaling`线程调用了`notify()`方法，唤醒了`waiting`线程，`waiting`线程继续执行

### 错过信号

如果在`waiting`线程调用`wait()`方法后，`signaling`线程没有调用`notify()`方法，那么`waiting`线程将一直等待下去

```java
public class Signaling {
    public static void main(String[] args) {
        Thread waiting = new Thread(() -> {
            synchronized (Signaling.class) {
                try {
                    System.out.println("Waiting...");
                    Signaling.class.wait();
                    System.out.println("Notified!");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Notifying...");
                    Signaling.class.notify();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        signaling.start(); // 先启动signaling线程，会错过信号
        waiting.start();

        try { // 等待线程结束
            waiting.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Notifying...
Waiting...
```

可以看到，`waiting`线程在`signaling`线程调用`notify()`方法之前就已经等待了，没有被唤醒，造成了错过信号，导致线程死锁

#### 解决方案

我们可以设置一个等待计数，在`waiting`线程中增加等待计数，在`signaling`线程中减少等待计数，当等待计数为0时，不再等待

```java
public class Signaling {
    
    public static void main(String[] args) {
        Thread waiting = new Thread(() -> {
            synchronized (Signaling.class) {
                try {
                    waitingCount++; // 增加等待计数
                    System.out.println("Waiting...");
                    Signaling.class.wait(); // 进入等待状态
                    System.out.println("Notified!");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                while (waitingCount > 0) { // 持续处理等待线程
                    System.out.println("Notifying...");
                    Signaling.class.notify();
                    waitingCount--; // 减少等待计数
                }
            }
        });

        waiting.start();
        signaling.start();

        try {
            waiting.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Waiting...
Notifying...
Notified!
```

### `notify` vs `notifyAll`

- `notify()` —— 唤醒一个正在等待的线程
- `notifyAll()` —— 唤醒所有正在等待的线程

```java
public class Signaling {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (Signaling.class) {
                Thread thread = Thread.currentThread();
                try {
                    System.out.println(thread.getName() + " is waiting...");
                    Signaling.class.wait();
                    System.out.println(thread.getName() + " is notified!");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread waiting1 = new Thread(runnable, "Waiting1");
        Thread waiting2 = new Thread(runnable, "Waiting2");
        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                System.out.println("Notifying...");
                Signaling.class.notifyAll();
            }
        });
        waiting1.start();
        waiting2.start();
        try {
            Thread.sleep(1000); // 等待1秒，确保Waiting1和Waiting2都已经开始等待
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        signaling.start();

        try {
            waiting1.join();
            waiting2.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Waiting1 is waiting...
Waiting2 is waiting...
Notifying...
Waiting1 is notified!
Waiting2 is notified!
```

可以看到，在`signaling`线程调用`notifyAll()`方法后，`waiting1`和`waiting2`线程都被唤醒了，继续执行

### 虚假唤醒

如果在`waiting`线程调用`wait()`方法后，`signaling`线程调用了`notify()`方法，但是`waiting`线程没有被唤醒，而是继续等待，这就是虚假唤醒

```java
public class Signaling {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread waiting = new Thread(() -> {
            synchronized (Signaling.class) {
                while (!flag) {
                    try {
                        System.out.println("Waiting...");
                        Signaling.class.wait();
                        System.out.println("Notified!");
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        waiting.start();

        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                System.out.println("Notifying...");
                flag = true;
                Signaling.class.notify();
            }
        });
        signaling.start();
        
        try {
            waiting.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```
Waiting...
Notifying...
Notified!
```