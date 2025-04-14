import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        
        Stack <Integer> stack = new Stack<>();
        System.out.println(stack.empty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.search(1));

    }
}