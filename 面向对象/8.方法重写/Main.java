public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();

        cat.move();
        dog.move();
        fish.move(); // 鱼是在水中移动的
    }
}