public class Car {
    private String brand;
    private String model;
    private String Colour;
    private int year;

    Car(String brand, String model, String Colour, int year) {
        this.brand = brand;
        this.model = model;
        this.Colour = Colour;
        this.year = year;
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getColour() {
        return Colour;
    }
    int getYear() {
        return year;
    }

    void setColour(String Colour) {
        this.Colour = Colour;
    }
}
