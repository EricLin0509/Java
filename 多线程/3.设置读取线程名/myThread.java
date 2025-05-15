public class myThread extends Thread {
    public void run() {
        // 获取当前线程的名称
        String threadName = Thread.currentThread().getName();
        System.out.println("当前线程的名称为：" + threadName);
    }
}