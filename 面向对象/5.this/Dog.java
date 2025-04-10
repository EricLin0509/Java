public class Dog {
    private String name;
    private int age;
    public Dog() {
        this("旺财", 2);
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}