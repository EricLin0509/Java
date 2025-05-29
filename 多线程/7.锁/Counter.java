import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long count = 0;
    private final Lock lock = new ReentrantLock(true);
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

    public static void tryLock() {
        Lock lock = new ReentrantLock();
        try {
            boolean lockSuccess = lock.tryLock(1000, TimeUnit.NANOSECONDS);
            System.out.println("获取锁状态：" + lockSuccess);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}