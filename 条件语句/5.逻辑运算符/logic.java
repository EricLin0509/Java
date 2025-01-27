import java.util.Scanner;

public class LogicOperator {
    public static void main(String[] args) {

        String username;
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        username = scanner.next();

        if(username.length() < 6 || username.length() > 12) {
            System.out.println("用户名长度必须在6-12位之间");
        }
        else if (username.contains(" ") || username.contains("_")) {
            System.out.println("用户名不能包含空格或下划线");   
        }
        else {
            System.out.println("你好" + username);
        }

        scanner.close();
    }
}