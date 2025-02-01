public class Break {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            System.out.print(i + " ");
            if (i == 10) {
                break;
            }
        }
        System.out.println();
    }
}