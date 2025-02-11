import java.util.Scanner;

public class inputarray {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();

        String[] foods = new String[num];
        scanner.nextLine(); // 清除缓冲区中的换行符

        for (int i = 0; i < foods.length; i++) {
            System.out.print("请输入一种食物：");
            foods[i] = scanner.nextLine();
        }

        for (String food : foods) {
            System.out.println(food);
        }

        scanner.close();

    }
}