public class Main {
    public static void main(String[] args) {
        
        Circle circle = new Circle(2.0);
        Triangle triangle = new Triangle(3.0, 4.0);

        circle.display();
        triangle.display();

        System.out.println("圆的面积：" + circle.area());
        System.out.println("三角形的面积：" + triangle.area());

        Shape shape = new Triangle(4, 7);
        shape.display();
        System.out.println("三角形的面积：" + shape.area());

    }
}
