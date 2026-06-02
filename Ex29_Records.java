// Exercise 29: Records (Java 16+)
import java.util.List;
import java.util.stream.Collectors;

public class Ex29_Records {

    // Compact, immutable data class — no boilerplate needed
    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob",   17);
        Person p3 = new Person("Carol", 22);
        Person p4 = new Person("Dave",  15);

        // Records auto-generate toString(), equals(), hashCode()
        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = List.of(p1, p2, p3, p4);

        // Filter adults (age >= 18) using Streams
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
