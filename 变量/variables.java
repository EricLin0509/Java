class Variables {
    // 成员变量
    static int num; // 定义一个静态整型变量 num
        public static void main(String[] args) {
        // 局部变量

        int age; // 定义一个整型变量 age
        age = 20; // 给 age 赋值为 20

        System.out.println(age); // 输出 age 的值

        int age2;
        // System.out.println(age2); // 错误：age2 没有被初始化，不能直接使用

        System.out.println("I am " + age + " years old."); // 格式化输出字符串和变量的值
        age = 22; // 给 age 重新赋值为 22
        // age，age2 都是局部变量，只能在 main 方法中使用

        System.out.println(num); // 输出 num 的值，因为成员变量会被默认初始化为 0

        int num = 10;
        System.out.println(num); // 输出10，因为局部变量会覆盖成员变量
    }
}
