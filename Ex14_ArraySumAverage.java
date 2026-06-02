// Exercise 14: Array Sum and Average
import java.util.Scanner;

public class Ex14_ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements? ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        for (int v : arr) sum += v;
        double avg = (double) sum / n;

        System.out.println("Sum     = " + sum);
        System.out.printf ("Average = %.2f%n", avg);
        sc.close();
    }
}
