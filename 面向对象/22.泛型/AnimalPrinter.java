public class AnimalPrinter <T extends Animal>  {
    T value;
    public AnimalPrinter(T value) {
        this.value = value;
    }
    public void print() {
        value.speak();
    }
}
