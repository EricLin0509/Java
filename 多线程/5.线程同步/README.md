# 线程同步

## 定义

在Java中，线程同步是指多个线程在访问共享资源时，通过一些机制来保证同一时间只有一个线程可以访问该资源，从而避免数据不一致或其他并发问题的发生

## 原理

在 `synchronized` 关键字的作用下，多个线程在访问共享资源时，会先获取到锁对象，然后执行代码块中的代码，执行完毕后释放锁对象，其他线程才能获取到锁对象并执行代码块中的代码

- 锁：在Java中，锁是一种用于控制多个线程对共享资源的访问的机制，它可以保证同一时间只有一个线程可以访问共享资源，从而避免数据不一致或其他并发问题的发生

- 锁对象：在Java中，每个对象都有一个内置的锁，也称为监视器锁（monitor lock）或内部锁（intrinsic lock）

## 语法

```java
public synchronized 返回值 方法名(参数列表) {
    // 方法体
}
```

或者

```java
synchronized (类名.class / this / lock) {
    // 代码块
}
```

## 代码示例

### 场景

设计两个线程同时对一个账户进行存款和取款操作

```java
public class Bank {
    private int balance = 1000;
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
}
```

```java
public class DepositThread extends Thread {
    private Bank bank;
    public DepositThread(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            bank.deposit(100);
        }
    }
}
```

```java
public class WithdrawThread extends Thread {
    private Bank bank;
    public WithdrawThread(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            bank.withdraw(100);
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread depositThread = new DepositThread(bank);
        Thread withdrawThread = new WithdrawThread(bank);
        depositThread.start();
        withdrawThread.start();
        try {
            depositThread.join();
            withdrawThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Balance: " + bank.getBalance());
    }
}
```


理想情况下，两个线程应该分别执行1000次存款和1000次取款，最终账户余额应该为1000

但是，由于线程的调度和执行顺序是不确定的，因此最终账户余额可能不为1000

```
Balance: -16500
```

#### 原因

[传送门](https://github.com/EricLin0509/C/tree/main/%E7%BA%BF%E7%A8%8B/3.%E7%AB%9E%E6%80%81%E6%9D%A1%E4%BB%B6#%E5%8E%9F%E5%9B%A0)

#### 解决方法 —— synchronized

```java
public class Bank {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance += amount;
    }
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
}
```

也可以是

```java
public class Bank {
    private int balance = 1000;
    public void deposit(int amount) {
        synchronized (this) {
            balance += amount;
        }
    }
    public void withdraw(int amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
    public int getBalance() {
        return balance;
    }
}
```

此时，两个线程分别执行1000次存款和1000次取款，最终账户余额应该为1000

```
Balance: 1000
```

### 静态方法

静态方法也可以使用`synchronized`关键字

**注意：在静态方法中，锁的是类对象，而不是实例对象**

```java
public class Bank {
    private static int balance = 1000;
    public static void deposit(int amount) {
        synchronized (Bank.class) {
            balance += amount;
        }
    }
    public static void withdraw(int amount) {
        synchronized (Bank.class) { // 注意这里是Bank.class，而不是this
            balance -= amount;
        }
    }
    public static int getBalance() {
        return balance;
    }
}
```

#### 为什么不能使用 `this` 作为锁对象

这是因为，静态方法是属于类的，而不是属于实例的

也就是说，**静态方法的锁对象是类对象，而不是实例对象**

### 使用不同的锁对象

如果需要使用不同的锁对象，可以使用`synchronized`关键字的另一种形式

```java
public class Monitor {
    private Object monitor1 = new Object(); // 锁对象1
    private Object monitor2 = new Object(); // 锁对象2

    private int counter1 = 0; // 计数器1
    private int counter2 = 0; // 计数器2

    public void increment1() {
        synchronized (monitor1) {
            counter1++;
        }
    }
    public void increment2() {
        synchronized (monitor2) {
            counter2++;
        }
    }
}
```

由于`monitor1`和`monitor2`是不同的锁对象，因此两个线程可以同时执行`increment1()`和`increment2()`方法

### 共享锁对象

共享锁对象是指多个线程可以同时获取到同一个锁对象，从而执行代码块中的代码

```java
public class ShareMonitor {
    private Object monitor = null; // 锁对象

    public ShareMonitor(Object monitor) {
        this.monitor = monitor; // 共享锁对象
    }
    
    int counter = 0;

    public void increment() {
        synchronized (this.monitor) {
            counter++;
        }
    }
}
```

**注意：锁对象不能为null，否则会抛出NullPointerException异常**


## Lambda表达式

使用Lambda表达式可以简化线程同步的代码

```java
public class Bank {
    private static int balance = 1000;
    public static void main(String[] args) {
        Thread deposit = new Thread(() -> {
            synchronized (Bank.class) {
                for (int i = 0; i < 1000; i++) {
                    balance += 100;
                }
            }
        });
        Thread withdraw = new Thread(() -> {
            synchronized (Bank.class) {
                for (int i = 0; i < 1000; i++) {
                    balance -= 100;
                }
            }
        });
        deposit.start();
        withdraw.start();
        System.out.println("Balance: " + balance);
    }
}
```

**注意：Lambda表达式中的 `synchronized` 不能使用 `this` 作为锁对象**

## 限制

- 只能同时有一个线程获取到锁对象，其他线程必须等待
- 不能保证线程的执行顺序