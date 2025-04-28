package package2;

import package1.*;

public class C {
    String s1 = "This is default"; // 默认的
    public String s2 = "This is public"; // 公共的
    private String s4 = "This is private"; // 私有的

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s4);
    }
}
