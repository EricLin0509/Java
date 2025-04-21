public class Main {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(1);
        integerPrinter.print();
        Printer<String> stringPrinter = new Printer<>("Hello World");
        stringPrinter.print();
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "Java", "Python", "C++" };
        Printer.printelements(intArray);
        Printer.printelements(stringArray);

        AnimalPrinter<Cat> catPrinter = new AnimalPrinter<>(new Cat("Tom"));
        catPrinter.print();
        System.out.println(catPrinter.getValue().name);
    }
}