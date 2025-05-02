import java.util.LinkedHashSet;
import java.util.Set;

public class linkhashset {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        // 插入顺序为 b, d, a, c
        set.add("b");
        set.add("d");
        set.add("a");
        set.add("c");
        System.out.println(set); // 输出顺序为 b, d, a, c
    }
}
