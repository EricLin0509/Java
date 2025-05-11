public class main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            myThread thread = new myThread(i);
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
    }
}