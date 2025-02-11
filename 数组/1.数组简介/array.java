import java.util.Arrays;

public class array {
    public static void main(String[] args) {

        String[] fruits = {"apple", "orange", "banana"};
        System.out.println(fruits[0]);
        System.out.println("\n");

        fruits[0] = "grape";
        System.out.println(fruits[0]);
        System.out.println("\n");

        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
        System.out.println("\n");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("\n");

        int[] nums = {1, 5, 3, 2, 4};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("\n");

        Arrays.fill(nums, 0);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}