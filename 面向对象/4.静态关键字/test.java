public class test {
    String name;
    static int num = 0;

    test (String name) {
        this.name = name;
        num++;
    }

    static void show_num() {
        System.out.println(num);
    }
}
