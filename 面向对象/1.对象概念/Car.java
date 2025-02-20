public class Car {
    String menufacturer = "BMW";
    String model = "E46 M3 CSL";
    int year = 2003;
    boolean isRunning = false;

    void start() {
        isRunning = true;
        System.out.println("车辆已启动");
    }

    void stop() {
        isRunning = false;
        System.out.println("车辆已停止");
    }

    void drive() {
        System.out.println("你驾驶着" + menufacturer + " " + model + "(" + year + ")");
    }
}