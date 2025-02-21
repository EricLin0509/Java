public class Students {

    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    Students(String name, int age, double gpa) { // 构造器
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true;
    }

    void enroll() {
        System.out.println(this.name + " is enrolled.");
    }
}