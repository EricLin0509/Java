public class Main {
    public static void main(String[] args) {
        
        Person person = new Person("John", "Doe");
        person.showName();

        Student student = new Student("Jane", "May", 3.5);
        student.showName();
        System.out.println(student.gpa);

        Employee employee = new Employee("Jame", "Doe", 50000);
        employee.showName();
    }
}