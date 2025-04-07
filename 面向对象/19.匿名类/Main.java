public class Main {
    public static void main(String[] args) {
        
        Dog dog1 = new Dog();
        dog1.bark();

        Dog dog2 = new Dog() {
            @Override
            void bark() {
                System.out.println("Bark!");
            }
        };
        dog2.bark();

    }
}
