import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class collections {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        Integer[] array = {1,2,3,4,5,6};
        Collections.addAll(list, array);
        Collections.sort(list);
        System.out.println(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(3);
        System.out.println(Collections.frequency(queue, 1)); // 逆序(大的在前面)
        System.out.println(queue);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map);

        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a"); // 相同的元素不会被添加
        System.out.println(set);
    
    }
}