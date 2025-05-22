public class DepositThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Bank.deposit(100);
        }
    }
}