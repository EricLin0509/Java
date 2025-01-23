import java.util.Scanner;

public class substrings {
    public static void main(String args[]) {
        
        String str = "abcdefghijklmn";

        String abcd = str.substring(0,4); // 取出abcd
        System.out.println(abcd);

        String email = "123456@gmail.com";

        String domain = email.substring(7); // 取出gmail.com
        System.out.println(domain);

        String domain1 = email.substring(email.indexOf("@")+1); // 取出gmail.com
        System.out.println(domain1);

        String username = email.substring(0, email.indexOf("@")); // 取出123456
        System.out.println(username);


        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入email:");
        String user_email = scanner.nextLine();

        String user;
        String domain2;

        if(user_email.contains("@")) { // 判斷是否有@
            user = user_email.substring(0, user_email.indexOf("@"));
            domain2 = user_email.substring(user_email.indexOf("@")+1);
            System.out.println(user);
            System.out.println(domain2);
        }
        else {
            System.out.println("格式错误");
        }

        scanner.close();
    }
}
