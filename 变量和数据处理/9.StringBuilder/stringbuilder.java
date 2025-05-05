public class stringbuilder {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("");
        sb.append("Hello");
        System.out.println(sb);
        sb.replace(0, 5, "World");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        String str = sb.toString();
        System.out.println(str);
    }
}