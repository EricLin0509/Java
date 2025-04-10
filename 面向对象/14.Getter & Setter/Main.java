public class Main {
    public static void main(String[] args) {
        Car car = new Car("AUDI", "RS6 AVANT GT", "White", 2025);
        System.out.println(car.getColour()+ " " + car.getBrand() + " " + car.getModel() + " " + car.getYear());

        car.setColour("Red");
        System.out.println(car.getColour()+ " " + car.getBrand() + " " + car.getModel() + " " + car.getYear());
    }
}