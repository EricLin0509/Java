public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(counter.getCount());
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(counter.getCount()); // 预期输出: 200
            }
        });
        thread1.start();
        thread2.start();

        Thread thread3 = new Thread(() -> {
            Counter.tryLock();
        });
        Thread thread4 = new Thread(() -> {
            Counter.tryLock();
        });
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
