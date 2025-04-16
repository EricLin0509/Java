public class Main {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(1);
        integerPrinter.print();
        Printer<String> stringPrinter = new Printer<>("Hello World");
        stringPrinter.print();

        AnimalPrinter<Cat> catPrinter = new AnimalPrinter<>(new Cat("Tom"));
        catPrinter.print();
    }
}