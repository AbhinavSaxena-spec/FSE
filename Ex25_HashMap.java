// Exercise 25: HashMap – Student ID to Name
import java.util.HashMap;
import java.util.Scanner;

public class Ex25_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add students (enter 0 as ID to stop):");
        while (true) {
            System.out.print("Student ID: ");
            int id = sc.nextInt();
            if (id == 0) break;
            sc.nextLine(); // consume newline
            System.out.print("Student Name: ");
            String name = sc.nextLine().trim();
            students.put(id, name);
            System.out.println("Added: " + id + " → " + name);
        }

        System.out.print("\nLook up student by ID: ");
        int lookupId = sc.nextInt();
        String found = students.get(lookupId);
        if (found != null)
            System.out.println("Student #" + lookupId + ": " + found);
        else
            System.out.println("No student found with ID " + lookupId);

        sc.close();
    }
}
