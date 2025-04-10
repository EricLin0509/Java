import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Animal animal; // 创建一个抽象类但不初始化的对象

        System.out.println("Enter animal type (1: dog, 2: cat): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            animal = new Dog(); // 初始化 为 Dog 对象
            animal.speak();
        }
        else if (choice == 2) {
            animal = new Cat(); // 初始化 为 Cat 对象
            animal.speak();
        }
        else {
            System.out.println("Invalid choice!");
        }

        scanner.close();

    }
}