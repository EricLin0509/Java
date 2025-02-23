public class Main {
    public static void main(String[] args) {
        Users user1 = new Users("James");
        System.out.println(user1.username);

        Users user2 = new Users("John", "john123@gmail.com");
        System.out.println(user2.username);
        System.out.println(user2.email);

        Users user3 = new Users("Jane", "jane456@outlook.com", 20);
        System.out.println(user3.username);
        System.out.println(user3.email);
        System.out.println(user3.age);

        Users user4 = new Users();
        System.out.println(user4.username);
        System.out.println(user4.email);
        System.out.println(user4.age);
    }
}