public class main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
        Outer.Inner inner = outer.new Inner();
        inner.show();

        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.show();

        outer.method(); // 非静态方法
        Outer.method2(); // 静态方法
    }
}
