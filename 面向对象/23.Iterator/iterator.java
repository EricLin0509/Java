import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class iterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C");
        list.add("Rust");
        list.add("Python");
        Iterator<String> iterator  = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        iterator.remove();
        
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String str = listIterator.next();
            System.out.println(str);
        }
        while (listIterator.hasPrevious()) {
            String str = listIterator.previous();
            System.out.println(str);
        }

        iterator.forEachRemaining((elements) -> {
            System.out.println(elements);
        });
    }
}