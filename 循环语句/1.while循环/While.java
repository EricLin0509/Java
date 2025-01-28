import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int age = 0;

        System.out.print("输入年龄：");
        age = scanner.nextInt();

        while (age < 0) {
            System.out.println("年龄不能为负数！");
            System.out.print("输入年龄：");
            age = scanner.nextInt();
        }

        System.out.println("年龄为：" + age);

        scanner.close();

    }
}