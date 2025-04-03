public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        feed(animal);
        Dog dog = new Dog();
        feed(dog);
        Cat cat = new Cat();
        feed(cat);
    }

    public static void feed(Animal animal) {
        animal.eat();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // 下转型对象
            dog.bark();
        }
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal; // 下转型对象
            cat.meow();
        }
    }
}