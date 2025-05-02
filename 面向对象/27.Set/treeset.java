import java.util.TreeSet;
import java.util.Set;

public class treeset {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        // 插入顺序为 b, d, a, c
        set.add("b");
        set.add("d");
        set.add("a");
        set.add("c");
        System.out.println(set); // 输出顺序为 a, b, c, d

        Set<student> set2 = new TreeSet<>();
        // 插入顺序为 b, d, a, c
        set2.add(new student("b", 18));
        set2.add(new student("d", 20));
        set2.add(new student("a", 19));
        set2.add(new student("c", 19));
        System.out.println(set2); // 输出顺序为 a, b, c, d
    }
}
