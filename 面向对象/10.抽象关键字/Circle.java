public class Circle extends Shape  {
    
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    @Override // 重写父类的抽象方法
    double area() {
        return Math.PI * radius * radius;
    }
}
