import java.util.Scanner;

public class forloop  {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入循环次数: ");
        int max = scanner.nextInt();

        for (int i = 1; i <= max; i++) {
            System.out.printf("第%d次循环\n",i);
        }

        scanner.close();

    }
}