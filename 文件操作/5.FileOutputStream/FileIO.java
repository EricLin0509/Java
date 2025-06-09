import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.File;

public class FileIO {
    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream(new File("data.txt"));
            String data = "Hello World!";
            byte[] bytes = data.getBytes();
            output.write(bytes);
            PrintStream printOut = new PrintStream(output);
            printOut.println("Hello, World!");
            printOut.flush();
            printOut.close();
            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}