import java.util.Scanner;
import java.util.InputMismatchException;

public class EHandle {
    public static void main(String[] args) {

        int y = 10;

        Scanner scanner = new Scanner(System.in);

        try {
        	System.out.print("输入一个整数: ");
            int x = scanner.nextInt();
            System.out.println(y / x);
        }
        catch (InputMismatchException e) {
            System.out.println("输入的不是整数");
        }
        catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }
        finally {
            scanner.close();
            System.out.println("Scanner已关闭");
        }
    }
}