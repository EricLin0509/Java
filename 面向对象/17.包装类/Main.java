public class Main {
    public static void main(String[] args) {
        Integer a = 100;
        Double b = 3.14;

        int x = a;
        double y = b;

        String c = Integer.toString(123);
        String d = Double.toString(3.14);

        int e = Integer.parseInt("100");
        double f = Double.parseDouble("3.14");
        char g = "Hello".charAt(0); 

        System.out.println(Character.isLetter(g));
        System.out.println(Character.isUpperCase(g));
    }
}