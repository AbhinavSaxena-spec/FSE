// Exercise 39: Reflection in Java
import java.lang.reflect.*;

public class Ex39_Reflection {

    // Sample class to inspect and invoke dynamically
    static class MathHelper {
        public int square(int x)       { return x * x; }
        public int cube(int x)         { return x * x * x; }
        private String secret(String s){ return s.toUpperCase() + "!"; }
    }

    public static void main(String[] args) throws Exception {
        // 1. Load class dynamically
        Class<?> clazz = Class.forName(
                Ex39_Reflection.class.getName() + "$MathHelper");

        System.out.println("Class: " + clazz.getName());

        // 2. List all declared methods (including private)
        System.out.println("\nDeclared Methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.printf("  %s %s(%s)%n",
                    m.getReturnType().getSimpleName(),
                    m.getName(),
                    getParamTypes(m));
        }

        // 3. Create an instance without new
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // 4. Invoke public method dynamically
        Method square = clazz.getMethod("square", int.class);
        Object result = square.invoke(instance, 7);
        System.out.println("\nsquare(7) via reflection = " + result);

        // 5. Invoke private method via setAccessible
        Method secret = clazz.getDeclaredMethod("secret", String.class);
        secret.setAccessible(true);
        Object secretResult = secret.invoke(instance, "hello");
        System.out.println("secret(\"hello\") via reflection = " + secretResult);
    }

    static String getParamTypes(Method m) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> p : m.getParameterTypes()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(p.getSimpleName());
        }
        return sb.toString();
    }
}
