package package2;

import package1.*;

public class D  extends B{
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.s1);

        D d = new D();
        System.out.println(d.s3);
    }
}