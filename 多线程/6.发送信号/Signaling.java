public class Signaling {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread waiting = new Thread(() -> {
            synchronized (Signaling.class) {
                while (!flag) {
                    try {
                        System.out.println("Waiting...");
                        Signaling.class.wait();
                        System.out.println("Notified!");
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        waiting.start();

        Thread signaling = new Thread(() -> {
            synchronized (Signaling.class) {
                System.out.println("Notifying...");
                flag = true;
                Signaling.class.notify();
            }
        });
        signaling.start();
        
        try {
            waiting.join();
            signaling.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}