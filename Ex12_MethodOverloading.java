// Exercise 12: Method Overloading
public class Ex12_MethodOverloading {

    // Two integers
    static int add(int a, int b) {
        return a + b;
    }

    // Two doubles
    static double add(double a, double b) {
        return a + b;
    }

    // Three integers
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("add(3, 4)         = " + add(3, 4));
        System.out.println("add(2.5, 3.7)     = " + add(2.5, 3.7));
        System.out.println("add(1, 2, 3)      = " + add(1, 2, 3));
    }
}
