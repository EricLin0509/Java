import java.util.Scanner; // 引入 Scanner 类

class Userinput {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in); // 创建 Scanner 对象

        System.out.print("请输入你的名字：");
        String name = scanner.nextLine(); // 读取一行输入

        System.out.println("你好" + name);

        System.out.print("请输入你的姓：");
        String first = scanner.next(); // 读取一个单词输入
        System.out.println("你的姓是" + first);

        System.out.print("请输入你的年龄：");
        int age = scanner.nextInt(); // 读取一个整数输入
        System.out.println("你的年龄是" + age);

        System.out.print("请输入你的体重：");
        double weight = scanner.nextDouble(); // 读取一个浮点数输入
        System.out.println("你的体重是" + weight);

        System.out.print("你是学生吗？(true/false)");
        boolean isStudent = scanner.nextBoolean(); // 读取一个布尔值输入
        System.out.println("学生：" + isStudent);

        scanner.nextLine(); // 读取换行符，避免影响下一次输入

        scanner.close(); // 关闭 Scanner 对象
    }
}