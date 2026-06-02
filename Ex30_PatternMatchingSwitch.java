// Exercise 30: Pattern Matching for switch (Java 21)
public class Ex30_PatternMatchingSwitch {

    static String describe(Object obj) {
        return switch (obj) {
            case Integer i  -> "Integer with value " + i;
            case Double  d  -> "Double with value "  + d;
            case String  s  -> "String of length "   + s.length() + ": \"" + s + "\"";
            case int[]   a  -> "int array of length " + a.length;
            case null       -> "null reference";
            default         -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(42));
        System.out.println(describe(3.14));
        System.out.println(describe("Hello, Java 21!"));
        System.out.println(describe(new int[]{1, 2, 3}));
        System.out.println(describe(null));
        System.out.println(describe(true));
    }
}
