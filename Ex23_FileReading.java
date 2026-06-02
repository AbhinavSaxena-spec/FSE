// Exercise 23: File Reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex23_FileReading {
    public static void main(String[] args) {
        System.out.println("Contents of output.txt:");
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
