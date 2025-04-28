package package1;

import package2.*;

public class A {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s2);

        B b = new B();
        System.out.println(b.s3);
    }
}
