// Exercise 22: File Writing
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex22_FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to save: ");
        String text = sc.nextLine();

        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(text);
            fw.write(System.lineSeparator());
            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        sc.close();
    }
}
