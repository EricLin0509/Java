public class Main {
    public static void main(String[] args) {
        
        Car car = new Car("Honda Civic Type R (FD2)", 2007, "K20A");

        System.out.println(car.model);
        System.out.println(car.year);
        System.out.println(car.engine.type);

        car.start();

    }
}
