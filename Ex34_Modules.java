// Exercise 34: Java Module System
// This exercise requires a specific directory layout. Below are all files with their paths.
// ─────────────────────────────────────────────────────────────────────────────
// Directory structure:
//   src/
//     com.utils/
//       module-info.java
//       com/utils/StringUtils.java
//     com.greetings/
//       module-info.java
//       com/greetings/Main.java
// ─────────────────────────────────────────────────────────────────────────────

// FILE 1: src/com.utils/module-info.java
/*
module com.utils {
    exports com.utils;
}
*/

// FILE 2: src/com.utils/com/utils/StringUtils.java
/*
package com.utils;

public class StringUtils {
    public static String greet(String name) {
        return "Hello, " + name + "! (from com.utils)";
    }

    public static String repeat(String s, int times) {
        return s.repeat(times);
    }
}
*/

// FILE 3: src/com.greetings/module-info.java
/*
module com.greetings {
    requires com.utils;
}
*/

// FILE 4: src/com.greetings/com/greetings/Main.java
/*
package com.greetings;

import com.utils.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.greet("World"));
        System.out.println(StringUtils.repeat("Java Modules! ", 3));
    }
}
*/

// ─────────────────────────────────────────────────────────────────────────────
// Compile & Run commands:
//   javac -d mods/com.utils  src/com.utils/module-info.java  src/com.utils/com/utils/StringUtils.java
//   javac -d mods/com.greetings --module-path mods  src/com.greetings/module-info.java  src/com.greetings/com/greetings/Main.java
//   java  --module-path mods --module com.greetings/com.greetings.Main
// ─────────────────────────────────────────────────────────────────────────────

// Standalone demo (single-file, no module system needed):
public class Ex34_Modules {
    // StringUtils inline for demonstration purposes
    static String greet(String name)           { return "Hello, " + name + "! (from com.utils)"; }
    static String repeat(String s, int times)  { return s.repeat(times); }

    public static void main(String[] args) {
        System.out.println(greet("World"));
        System.out.println(repeat("Java Modules! ", 3));
        System.out.println("\n-- See file comments above for full module setup & compile instructions --");
    }
}
