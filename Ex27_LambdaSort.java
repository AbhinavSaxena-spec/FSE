// Exercise 27: Lambda Expressions – Sort strings
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex27_LambdaSort {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Mango", "Cherry", "Date");

        System.out.println("Before sorting: " + fruits);

        // Sort ascending with lambda
        Collections.sort(fruits, (a, b) -> a.compareTo(b));
        System.out.println("Ascending      : " + fruits);

        // Sort descending with lambda
        fruits.sort((a, b) -> b.compareTo(a));
        System.out.println("Descending     : " + fruits);

        // Sort by length with lambda
        fruits.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("By length      : " + fruits);
    }
}
