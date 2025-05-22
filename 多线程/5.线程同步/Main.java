public class Main {
    public static void main(String[] args) {
        Thread depositThread = new DepositThread();
        Thread withdrawThread = new WithdrawThread();
        depositThread.start();
        withdrawThread.start();
        try {
            depositThread.join();
            withdrawThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Balance: " + Bank.getBalance());
    }
}