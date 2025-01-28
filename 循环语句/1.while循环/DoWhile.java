import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int number = 0;

        do {
            System.out.print("输入一个1至10之间的整数：");
            number = scanner.nextInt();
        } while (number < 1 || number > 10);

        System.out.println("输入的整数为：" + number);

        scanner.close();

    }
}