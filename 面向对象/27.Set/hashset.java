import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 插入顺序为 b, d, a, c
        set.add("b");
        set.add("d");
        set.add("a");
        set.add("c");
        System.out.println(set); // 输出顺序为 a, b, c, d

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // 遍历集合
        }
    }
}