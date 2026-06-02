// Exercise 37: Using javap to Inspect Bytecode
//
// STEP 1 – Compile this file:
//   javac Ex37_BytecodeDemo.java
//
// STEP 2 – Inspect with javap (basic):
//   javap Ex37_BytecodeDemo
//
// STEP 3 – Full bytecode disassembly:
//   javap -c Ex37_BytecodeDemo
//
// STEP 4 – With constants, line numbers, locals:
//   javap -verbose Ex37_BytecodeDemo
//
// Expected javap -c output (abbreviated):
//   public static int add(int, int);
//     Code:
//        0: iload_0         // push a
//        1: iload_1         // push b
//        2: iadd            // add top two ints
//        3: ireturn         // return int result
//
// Key bytecode mnemonics:
//   iload_N  – load int from local slot N onto stack
//   iadd     – pop two ints, push their sum
//   ireturn  – return int on stack
//   invokevirtual – call instance method
//   getstatic     – read a static field (e.g., System.out)
//   ldc      – push a constant (string / int literal)

public class Ex37_BytecodeDemo {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("3 + 4     = " + add(3, 4));
        System.out.println("5!        = " + factorial(5));
        System.out.println("See javap instructions in this file's comments.");
    }
}
