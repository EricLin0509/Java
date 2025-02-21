public class Main {
    public static void main(String[] args) {
        
        Students students1 = new Students("John", 19, 3.5); // 调用构造器
        System.out.println(students1.name);
        System.out.println(students1.age);
        System.out.println(students1.gpa);
        System.out.println(students1.isEnrolled);
        students1.enroll(); // 调用方法

        Students students2 = new Students("Jane", 20, 3.0); // 调用构造器
        System.out.println(students2.name);
        System.out.println(students2.age);
        System.out.println(students2.gpa);
        System.out.println(students1.isEnrolled);
        students2.enroll(); // 调用方法

    }
}