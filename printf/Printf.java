public class Printf {
    public static void main(String[] args) {
        
        String name = "John";
        char firstLetter = 'J';
        int age = 30;
        double height = 170.5;
        boolean isStudent = true;

        System.out.printf("My name is %s\n" , name); // 格式化输出
        System.out.printf("My first letter is %c\n", firstLetter);
        System.out.printf("I am %d years old\n", age);
        System.out.printf("My height is %.2f\n", height);
        System.out.printf("I am a student: %b\n", isStudent);

    }
}