# 锁

## 定义

在 Java 多线程中，锁是一种同步机制，用于控制对共享资源的访问。锁可以确保在同一时间只有一个线程可以访问共享资源，从而避免了多线程环境下的数据不一致问题

一共有 4 种锁

- `ReentrantLock` —— 可重入锁
- `ReentrantReadWriteLock` —— 读写锁
- `StampedLock` —— 乐观锁
- `SpinLock` —— 自旋锁

`Lock` 机制与 `synchronized` 关键字大致相同，但是 `Lock` 机制更加灵活，提供了更多的功能

## 代码示例

### 使用 `synchronized` 关键字

```java
// Counter.java

public class Counter {
    private long count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized long getCount() {
        return count;
    }
}
```

同样的，我们也可以使用 `ReentrantLock` 来实现

### 使用 `ReentrantLock` 关键字

```java
// Counter.java

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long count = 0;
    private final Lock lock = new ReentrantLock();
    public void increment() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
    public long getCount() {
        try {
            lock.lock();
            return count;
        } finally {
            lock.unlock();
        }
    }
}
```

- `lock.lock()` —— 获取锁
- `lock.unlock()` —— 释放锁

### 锁公平性

锁的公平性指的是，锁的获取顺序是否与请求锁的顺序一致。如果锁是公平的，那么锁的获取顺序与请求锁的顺序一致；如果锁是非公平的，那么锁的获取顺序与请求锁的顺序无关

由于 `ReentrantLock` 默认是非公平的，那么有可能会出现**某些线程一直无法获取锁的情况**，这样就会导致线程饥饿 (starvation)

可以传入 `true` 来创建一个公平的锁

```java
Lock lock = new ReentrantLock(true);
```

### `Lock.lockInterruptibly()`

`Lock.lockInterruptibly()` 方法与 `Lock.lock()` 方法类似，但是 `Lock.lockInterruptibly()` 方法可以响应中断。如果当前线程没有获得锁，那么 `Lock.lockInterruptibly()` 方法会抛出 `InterruptedException` 异常

```java
private static void lockInterruptibly() {
    Lock lock = new ReentrantLock();
    try {
        lock.lockInterruptibly();
        System.out.println("获取锁成功");
        lock.unlock();
    }
    catch (InterruptedException e) {
        System.out.println("获取锁失败");
    }
}
```

```
获取锁成功
```

但是如果中断了当前线程，那么 `Lock.lockInterruptibly()` 方法会抛出 `InterruptedException` 异常

```java
private static void lockInterruptibly() {
    Lock lock = new ReentrantLock();
    Thread.currentThread().interrupt(); // 中断当前线程
    try {
        lock.lockInterruptibly();
        System.out.println("获取锁成功");
        lock.unlock();
    }
    catch (InterruptedException e) {
        System.out.println("获取锁失败");
    }
}
```

```
获取锁失败
```

### `Lock.tryLock()`

`Lock.tryLock()` 方法与 `Lock.lock()` 方法类似，但是 `Lock.tryLock()` 方法不会阻塞当前线程，而是立即返回一个布尔值，表示是否获取到锁

```java
public static void tryLock() {
    Lock lock = new ReentrantLock();
    try {
        boolean lockSuccess = lock.tryLock();
        System.out.println("获取锁状态：" + lockSuccess);
    }
    finally {
        lock.unlock();
    }
}
```

```
获取锁状态：true
```

我们可以传入一个参数，表示尝试获取锁的时间

```java
public static void tryLock() {
    Lock lock = new ReentrantLock();
    try {
        boolean lockSuccess = lock.tryLock(1000, TimeUnit.NANOSECONDS);
        System.out.println("获取锁状态：" + lockSuccess);
    }
    finally {
        lock.unlock();
    }
}
```

`TimeUnit.MILLISECONDS` 此处可以替换为其他时间单位

- `TimeUnit.DAYS` —— 天
- `TimeUnit.HOURS` —— 小时
- `TimeUnit.MINUTES` —— 分钟
- `TimeUnit.SECONDS` —— 秒
- `TimeUnit.MILLISECONDS` —— 毫秒
- `TimeUnit.MICROSECONDS` —— 微秒
- `TimeUnit.NANOSECONDS` —— 纳秒

### `ReentrantLock` 方法

- `lock()` —— 获取锁
- `unlock()` —— 释放锁
- `tryLock()` —— 尝试获取锁
- `tryLock(long time, TimeUnit unit)` —— 尝试获取锁，指定时间内
- `lockInterruptibly()` —— 可中断地获取锁
- `isHeldByCurrentThread()` —— 判断当前线程是否持有锁
- `isLocked()` —— 判断锁是否被任何线程持有
- `hasQueuedThreads()` —— 判断是否有线程在等待获取锁
- `getHoldCount()` —— 获取当前线程持有锁的次数
- `getQueueLength()` —— 获取等待获取锁的线程数

## `ReentrantLock` 与 `synchronized` 关键字的区别

|      | `ReentrantLock` | `synchronized` |
| :--: | :-------------: | :------------: |
| 公平性 |      可选择     |     非公平     |
|  锁状态  |     可中断     |     不可中断     |
|  锁状态  |     可重入     |     不一定可重入     |
| 可以在不同的方法中加解锁 |      是      |      否      |