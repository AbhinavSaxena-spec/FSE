// Exercise 10: Number Guessing Game
import java.util.Random;
import java.util.Scanner;

public class Ex10_NumberGuessingGame {
    public static void main(String[] args) {
        int secret = new Random().nextInt(100) + 1;
        Scanner sc  = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100!");
        while (true) {
            System.out.print("Your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if      (guess < secret) System.out.println("Too low!  Try again.");
            else if (guess > secret) System.out.println("Too high! Try again.");
            else {
                System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                break;
            }
        }
        sc.close();
    }
}
