public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(name + " Running");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
