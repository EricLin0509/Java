public class nestedif {
    public static void main(String[] args) {
        
        boolean isStudent = true;
        boolean isSenior = true;
        double price = 9.99;

        if(isStudent) {

            if (isSenior) {
                System.out.println("你获得了青少年折扣");
                System.out.println("你获得了学生折扣");
                price *=  0.6; // 6折
            }
            else {
                System.out.println("你获得了学生折扣");
                price *=  0.8; // 8折
            }
        }
        else {
            price *= 1;
        }

        System.out.printf("价格为：%.2f", price);
    }
}