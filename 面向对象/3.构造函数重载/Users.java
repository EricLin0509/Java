public class Users {
    
    String username;
    String email;
    int age;

    Users(String username) {
        this.username = username;
    }

    Users(String username, String email) { // 构造器重载
        this.username = username;
        this.email = email;
    }

    Users(String username, String email, int age) { // 构造器重载
        this.username = username;
        this.email = email;
        this.age = age;
    }

    Users() {
        this.username = "Guest";
        this.email = "N/A";
        this.age = 0;
    }
}