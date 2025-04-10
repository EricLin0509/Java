public class Car {

    String menufacturer;
    String model;
    int year;
    String colour;

    Car(String make, String model, int year, String color) {
        this.menufacturer = make;
        this.model = model;
        this.year = year;
        this.colour = color;
    }

    @Override // 重写toString方法
    public String toString() {
        return colour + " " + year + " " + menufacturer + " " + model;
    }

}