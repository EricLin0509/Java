public class Bank {
    private static int balance = 1000;
    public static void deposit(int amount) {
        synchronized (Bank.class) {
            balance += amount;
        }
    }
    public static void withdraw(int amount) {
        synchronized (Bank.class) {
            balance -= amount;
        }
    }
    public static int getBalance() {
        return balance;
    }
}