public class overloaded {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }
    public static double add(double num1, double num2, double num3) {
        return num1 + num2 + num3;
    }
}
