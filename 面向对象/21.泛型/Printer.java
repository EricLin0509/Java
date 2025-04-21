public class Printer<T> {
    T value;
    public Printer(T value) {
        this.value = value;
    }
    public void print() {
        System.out.println(value);
    }

    public static <T> void printelements(T[] inputArray) {
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}
