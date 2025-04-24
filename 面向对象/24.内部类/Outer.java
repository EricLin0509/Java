public class Outer {
    int num = 10;
    public void show() {
        System.out.println(num);
    }

    public void method() { // 非静态方法
        class LocalInner {
            int num = 40;
            public void show() {
                System.out.println(num);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.show();
    }

    public static void method2() { // 静态方法
        class LocalInner {
            int num = 50;
            public void show() {
                System.out.println(num);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.show();
    }

    public class Inner {
        int num = 20;
        public void show() {
            System.out.println(num);
        }
    }

    public static class StaticInner {
        int num = 30;
        public void show() {
            System.out.println(num);
        }
    }
}