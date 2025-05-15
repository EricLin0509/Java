public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new myThread(i));
            thread.start();
            while (thread.isAlive()) {
                System.out.println("Thread " + i + " is alive");
            }
            try {
                thread.join(); // 等待线程执行完成
                System.out.println("Thread " + i + " finished");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 1; i <= 3; i++) {
            Runnable task1 = new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 5; j++) {
                        System.out.println("Hello from thread " + j);
                    }
                }
            };
            Thread thread = new Thread(task1);
            thread.start();
        }

        for (int i = 1; i <= 3; i++) {
            Runnable task2 = () -> {
                for (int j = 1; j <= 5; j++) {
                    System.out.println("Hello from thread " + j);
                }
            };
            Thread thread = new Thread(task2);
            thread.start();
        }
    }
}