import java.util.Random; // 引入Random的套件

class random {
    public static void main(String[] args) {
        
        Random random = new Random();

        int number1;
        double number2;
        boolean number3;

        number1 = random.nextInt(1, 101); // 生成1~100的随机整数
        System.out.println(number1);

        number2 = random.nextDouble(1, 101); // 生成1~100的随机小数
        System.out.println(number2);

        number3 = random.nextBoolean(); // 生成true或false
        System.out.println(number3);

    }
}