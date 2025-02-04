public class method {
    public static void main(String[] args) {
        
       String name = "John";
        // 调用方法
        sayHello(name);

        double num = square(16);
        System.out.println(num);

        String full_name = full_name("John", "Doe");
        System.out.println(full_name);
    }
    // 定义方法
    static void sayHello(String name) {
        System.out.printf("Hello, %s!\n", name);
    }
    static double square(double number) {
        return number * number;
    }
    static String full_name(String first_name, String last_name) {
        return first_name + " " + last_name;
    }
}
