// Exercise 16: Palindrome Checker
import java.util.Scanner;

public class Ex16_PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed))
            System.out.println("\"" + input + "\" IS a palindrome.");
        else
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        sc.close();
    }
}
