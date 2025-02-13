public class search {
    public static void main(String[] args) {
        String[] fruits = {"apple", "banana", "orange"};
        String target = "pineapple";
        boolean isFound = false;

        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i].equals(target)) {
                System.out.println("在数组中找到了目标值，下标为：" + i);
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("在数组中没有找到目标值");
        }
    }
}