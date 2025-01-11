import java.util.Scanner;

class If {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int age;
        String name;

        System.out.print("请输入你的年龄：");
        age = scanner.nextInt();
        System.out.print("请输入你的名字：");
        name = scanner.next();

        if (name.isEmpty()) {
            System.out.println("你还没有输入名字");
        }
        else {
            System.out.println("你好" + name);
        }

        if (age >= 18) {
            System.out.println("你是成年人");
        }
        else if(age < 0) {
            System.out.println("你还没出生");
        }
        else{
            System.out.println("你是未成年人");
        }

        scanner.close();

    }
}