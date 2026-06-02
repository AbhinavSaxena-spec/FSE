// Exercise 24: ArrayList – Student Name Manager
import java.util.ArrayList;
import java.util.Scanner;

public class Ex24_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to finish):");
        while (true) {
            System.out.print("> ");
            String name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("done")) break;
            if (!name.isEmpty()) names.add(name);
        }

        System.out.println("\nAll students (" + names.size() + "):");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
        sc.close();
    }
}
