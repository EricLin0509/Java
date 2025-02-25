public class Main {
    public static void main(String[] args) {

        test name1 = new test("John");

        System.out.println(test.num); // 使用静态方法访问

        test name2 = new test("Jane");

        System.out.println(test.num); // 使用静态方法访问

        name1.show_num();
    }
}