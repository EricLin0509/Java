public class scpoe {

    int b = 40;
    public static void main(String[] args) {
        int a = 10;
        System.out.printf("a = %d\n", a);

        int b = 20;
        System.out.printf("b from main = %d\n", b);
        test();
    }
    public static void test() {
        int b = 30;
        System.out.printf("b from method = %d\n", b);
    }
}
