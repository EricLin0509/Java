public class Lambda {
    public static void main(String[] args) {
        Printable printable = (str1, str2) -> {
            String result = str1 + " " + str2 + " Meow!";
            System.out.println(result);
            return result;
        };
        System.out.println(printThings(printable));
    }

    public static String printThings(Printable printable) {
        return printable.print("Meow!", "Meow!");
    }
}