import java.util.Scanner;

public class nestedloop {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入行数：");
        int rows = scanner.nextInt();

        System.out.print("输入列数：");
        int columns = scanner.nextInt();

        scanner.nextLine();

        System.err.print("输入符号：");
        char symbol = scanner.next().charAt(0);

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }

        scanner.close();

    }
}