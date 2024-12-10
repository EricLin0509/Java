class datatypes {
    public static void main(String[] args) {
        // 整形类型
        byte aByte = 127; // -128 ~ 127
        short aShort = 32767; // -32768 ~ 32767
        int aInteger = 2147483647; // -2147483648 ~ 2147483647
        long aLong = 9223372036854775807L; // -9223372036854775808 ~ 9223372036854775807
        // 注意：Java 默认的整型是 int 类型，所以在定义 long 类型时需要在数字后面加上 L


        // 浮点型类型
        float aFloat = 3.14F; // 4.9E-324 ~ 3.4028235E+38
        double aDouble = 3.14159265358979323846; // 1.4E-45 ~ 1.7976931348623157E+308
        // 注意：Java 默认的浮点型是 double 类型，所以在定义 float 类型时需要在数字后面加上 F


        // 布尔型类型
        boolean isTrue = true;
        boolean isFalse = false;


        // 字符型类型
        char aChar = '\u00A9'; // 任何有效的 Unicode 字符
        System.out.println(aChar); // 输出 © 符号


        // 类型转换
        int num1 = 5;
        double num = num1; // 自动类型转换
        System.out.println(num); // 输出 5.0

        double num2 = 5.5;
        // int num3 = num2; // 错误，因为 double 类型比 int 类型范围更大，需要强制类型转换
        int num3 = (int) num2; // 强制类型转换
        System.out.println(num3); // 输出 5
    }
}
