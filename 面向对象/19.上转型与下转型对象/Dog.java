public class Dog extends Animal {
    
    public void bark() {
        System.out.println("The dog is barking.");
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating.");
    }
}