import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("..//output.txt")) {
            writer.write("Hello World!");
            System.out.println("File written successfully");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Can't write to file");
        }
    }
}