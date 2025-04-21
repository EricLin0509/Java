import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.isEmpty());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.isEmpty()); // 检查队列是否为空

        queue.poll();
        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue.size());

        System.out.println(queue.contains(2));
    }
}