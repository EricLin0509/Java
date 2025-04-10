public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        car.go();
        bike.go();

        Vehicle[] vehicles = {car, bike};

        for (Vehicle vehicle : vehicles) {
            vehicle.go();
        }

    }
}