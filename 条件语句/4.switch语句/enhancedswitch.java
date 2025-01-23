import java.util.Scanner;

public class enhancedswitch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个星期的英文名称：");
        String day = scanner.nextLine();

        switch(day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
                    System.out.println("It's a weekday");

            case "Saturday", "Sunday" ->
                    System.out.println("It's a weekend");

            default-> System.out.println("Invalid day");
        }

        scanner.close();
    }
}
