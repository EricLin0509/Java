class Operators {
    public static void main(String[] args) {
        
        int num1 = 12;
        int num2 = 23;


        // 算术运算符

        // 加法
        System.out.println(num1 + num2);

        // 减法
        System.out.println(num1 - num2);

        // 乘法
        System.out.println(num1 * num2);

        // 除法
        System.out.println(num1 / num2);

        // 求余
        System.out.println(num1 % num2);

        
        int number = 12;

        //简化赋值运算符

        number += 12;
        System.out.println(number);

        number -= 12;
        System.out.println(number);

        number *= 12;
        System.out.println(number);
        
        number /= 12;
        System.out.println(number);

        number %= 12;
        System.out.println(number);


        int num = 10;
        
        // 自增自减运算符

        // 自增
        System.out.println(num++); // 先输出，后自增
        System.out.println(++num); // 先自增，后输出

        // 自减
        System.out.println(num--); // 先输出，后自减
        System.out.println(--num); // 先自减，后输出


        // 关系运算符

        // 大于
        System.out.println(num1 > num2);
        
        // 小于
        System.out.println(num1 < num2);

        // 大于等于
        System.out.println(num1 >= num2);

        // 小于等于
        System.out.println(num1 <= num2);

        // 等于
        System.out.println(num1 == num2);

        // 不等于
        System.out.println(num1 != num2);


        int age = 19;

        // 逻辑运算符

        // 与 (and)
        System.out.println(age > 18 && age < 25);

        // 或 (or)
        System.out.println(age > 18 || age < 25);

        // 非 (not)
        System.out.println(!(age > 18));

    }
}