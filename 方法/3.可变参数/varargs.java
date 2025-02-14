public class varargs {
    public static void main(String[] args) {
        double average1 = average(1, 2, 3, 4, 5);
        System.out.println(average1);

        double average2 = average(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(average2);
    }
    public static double average(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
