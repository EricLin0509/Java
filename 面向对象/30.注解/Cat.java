@Animal(Type = "Cat")
public class Cat {
    private String name;
    private int age;
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }

    @Animal(Type = "Cat")
    public void meow() {
        System.out.println("Meow!");
    }
}