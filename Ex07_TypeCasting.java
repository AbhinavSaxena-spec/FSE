// Exercise 7: Type Casting Example
public class Ex07_TypeCasting {
    public static void main(String[] args) {
        // double → int (explicit / narrowing cast)
        double myDouble = 9.99;
        int fromDouble = (int) myDouble;
        System.out.println("double " + myDouble + " cast to int: " + fromDouble);

        // int → double (implicit / widening cast)
        int myInt = 7;
        double fromInt = myInt;            // widening — no cast needed
        System.out.println("int " + myInt + " cast to double: " + fromInt);
    }
}
