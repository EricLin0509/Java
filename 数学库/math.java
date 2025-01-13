import java.util.Scanner;

public class math {
    public static void main(String[] args) {

        System.out.println(Math.PI); // 圆周率
        System.out.println(Math.E); // 自然对数的底数

        double result;

        result = Math.pow(2, 3); // 2的3次方
        System.out.println(result);

        result = Math.abs(-5); // 绝对值
        System.out.println(result);

        result = Math.sqrt(16); // 平方根
        System.out.println(result);

        result = Math.round(3.5); // 四舍五入
        System.out.println(result);

        result = Math.ceil(result); // 向上取整
        System.out.println(result);

        result = Math.floor(result); // 向下取整
        System.out.println(result);

        result = Math.min(10, 20); // 最小值
        System.out.println(result);

        result = Math.max(10, 20); // 最大值
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double c;

        System.out.print("请输入a的值：");
        a = scanner.nextDouble();

        System.out.print("请输入b的值：");
        b = scanner.nextDouble();

        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // 勾股定理
        System.out.println("c的值为：" + c);

        scanner.close();
    }
}
