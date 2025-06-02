import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            String line; // 保存读取到的文本
            while ((line = bufferedReader.readLine()) != null) { // 读取到文件末尾时返回 null
                System.out.println(line); // 输出读取到的文本
            }
            bufferedReader.close(); // 关闭 BufferedReader 对象
        }
        catch (IOException e) {
        System.out.println("Cannot read file");
        }
    }
}