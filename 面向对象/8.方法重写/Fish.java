public class Fish extends Animal {
    
    @Override // 用于标识这是一个重写方法
    void move() {
        System.out.println("This animal is swimming...");
    }
}
