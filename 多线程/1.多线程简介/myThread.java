public class myThread implements Runnable {
    private int id;
    public myThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from thread " + id + " " + Thread.currentThread().getName());
        }
    }
}