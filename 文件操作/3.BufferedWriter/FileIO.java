import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {

        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        String[] names = {"Tom", "Jerry", "Spike", "Tyke"};

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"))) {
            bufferedWriter.write("Hello World!\n");
            bufferedWriter.write("Hello World again!\n");

            bufferedWriter.write(chars, 0, 5); // Hello
            bufferedWriter.newLine(); // 换行

            for (String name : names) {
                bufferedWriter.write(name);
                bufferedWriter.newLine(); // 换行
            }
            
            bufferedWriter.close(); // 关闭 BufferedWriter
        }
        catch (IOException e) {
            System.out.println("Cannot write to file");
        }
    }
}