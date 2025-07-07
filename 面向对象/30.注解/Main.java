public class Main {
    public static void main(String[] args) {        
        Cat cat = new Cat("Tom", 1);

        if (cat.getClass().isAnnotationPresent(Animal.class)) {
            System.out.println("This is an animal.");
        } else {
            System.out.println("This is not an animal.");
        }

        Animal annotation = cat.getClass().getAnnotation(Animal.class); // 获取 Cat 类的 Animal 注解

        if (annotation != null) {
            System.out.println("This is a " + annotation.Type() + "."); // 获取注解中 Type 属性的值
        }
        else {
            System.out.println("This is not an animal.");
        }
    }
}