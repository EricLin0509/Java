import java.util.ArrayList; // 导入 ArrayList 类
import java.util.Collections; // 导入 Collections 类

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // 创建一个 ArrayList 对象并设置存储类型为 Integer

        list.add(1); // 添加元素 1
        list.add(2); // 添加元素 2
        list.add(3); // 添加元素 3

        System.out.println(list); // 输出 ArrayList 对象

        list.set(1, 4); // 将索引为 1 的元素替换为 4
        System.out.println(list); // 输出 ArrayList 对象

        System.out.println(list.get(1)); // 获取索引为 1 的元素

        System.out.println(list.size()); // 获取 ArrayList 的长度

        Collections.sort(list); // 对 ArrayList 进行排序
        System.out.println(list); // 输出 ArrayList 对象

        for (int num : list) {
            System.out.println(num); // 遍历 ArrayList 对象
        }
    }
}