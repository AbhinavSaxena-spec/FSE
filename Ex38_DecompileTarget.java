// Exercise 38: Decompile a Class File
//
// STEP 1 – Write and compile a simple Java program
//
// STEP 2 – Decompile using CFR (command-line decompiler):
//   java -jar cfr.jar Ex38_DecompileTarget.class
//
// STEP 3 – Or use JD-GUI:
//   Open JD-GUI → File → Open → select Ex38_DecompileTarget.class
//
// STEP 4 – Analyse the decompiled source:
//   • Check how the compiler transforms enhanced for loops (for-each → iterator)
//   • Check how String concatenation becomes StringBuilder.append() chains
//   • Check how lambda expressions become invokedynamic + synthetic methods
//
// ────────────────────────────────────────────────────────────────────────────
// Example class to compile then decompile:

import java.util.Arrays;
import java.util.List;

public class Ex38_DecompileTarget {

    // Demonstrates: for-each → iterator bytecode
    static void printList(List<String> items) {
        for (String item : items) {
            System.out.println("Item: " + item);
        }
    }

    // Demonstrates: lambda → invokedynamic
    static void sortAndPrint(List<String> items) {
        items.stream()
             .sorted((a, b) -> a.compareTo(b))
             .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango", "Apple", "Banana");
        printList(fruits);
        System.out.println("-- sorted --");
        sortAndPrint(fruits);

        System.out.println("\nCompile this class and open the .class file in");
        System.out.println("JD-GUI or run: java -jar cfr.jar Ex38_DecompileTarget.class");
    }
}
