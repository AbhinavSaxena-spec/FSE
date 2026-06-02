// Exercise 8: Operator Precedence
public class Ex08_OperatorPrecedence {
    public static void main(String[] args) {
        // Multiplication before addition
        int r1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + r1 + "  (* evaluated first → 10 + 10 = 20)");

        // Parentheses override precedence
        int r2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + r2 + "  (parentheses first → 15 * 2 = 30)");

        // Mixed arithmetic
        int r3 = 100 / 5 + 3 * 4 - 2;
        System.out.println("100 / 5 + 3 * 4 - 2 = " + r3 + "  (/ and * first: 20 + 12 - 2 = 30)");

        // Modulus in a compound expression
        int r4 = 10 % 3 + 4 * 2;
        System.out.println("10 % 3 + 4 * 2 = " + r4 + "  (% and * first: 1 + 8 = 9)");
    }
}
