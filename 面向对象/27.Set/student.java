public class student implements Comparable<student>  {
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(student other) {
        if (this.age != other.age) {
            return this.age - other.age;
        }
        else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() { // 重写toString方法，方便输出
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
