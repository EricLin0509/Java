public class Main {
    public static void main(String[] args) {
        // 创建线程对象
        myThread thread = new myThread();
        // 启动线程
        thread.start();

        Runnable runnable = () -> {
            // 获取当前线程的名称
            String threadName = Thread.currentThread().getName();
            System.out.println("当前线程的名称为：" + threadName);
        };
        // 创建线程对象
        Thread thread1 = new Thread(runnable);
        // 设置线程名称
        thread1.setName("MyThread");
        // 启动线程
        thread1.start();
    }
}