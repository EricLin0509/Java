public class Triangle extends Shape {
    
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return base * height / 2;
    }

}
