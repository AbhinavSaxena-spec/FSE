Core Java Exercises 
1. Hello World Program 
• Objective: Understand the basic structure of a Java program. 
• Task: Write a Java program that prints "Hello, World!" to the console. 
• Instructions: 
o Create a class named HelloWorld. 
o Implement the main method. 
o Use System.out.println() to display the message. 
2. Simple Calculator 
• Objective: Practice arithmetic operations and user input. 
• Task: Develop a calculator that performs addition, subtraction, multiplication, and division. 
• Instructions: 
o Prompt the user to enter two numbers. 
o Ask the user to choose an operation. 
o Display the result of the operation. 
3. Even or Odd Checker 
• Objective: Utilize conditional statements. 
• Task: Determine if a number entered by the user is even or odd. 
• Instructions: 
o Prompt the user for an integer. 
o Use the modulus operator % to check divisibility by 2. 
o Display whether the number is even or odd. 
4. Leap Year Checker 
• Objective: Apply nested conditional logic. 
• Task: Check if a given year is a leap year. 
• Instructions: 
o Prompt the user to enter a year. 
o A year is a leap year if it's divisible by 4 but not by 100, unless it's also divisible by 400. 
o Display the result accordingly. 
5. Multiplication Table 
• Objective: Implement loops. 
• Task: Print the multiplication table for a number up to 10. 
• Instructions: 
o Prompt the user for a number. 
o Use a for loop to iterate from 1 to 10. 
o Multiply the input number by the loop counter and display the result. 
6. Data Type Demonstration 
• Objective: Understand Java's primitive data types. 
• Task: Declare variables of different primitive types and display their values. 
• Instructions: 
o Declare variables of types int, float, double, char, and boolean. 
o Assign appropriate values to each. 
o Use System.out.println() to display each variable. 
7. Type Casting Example 
• Objective: Practice type casting between different data types. 
• Task: Convert a double to an int and vice versa. 
• Instructions: 
o Declare a double variable with a decimal value. 
o Cast it to an int and display the result. 
o Declare an int variable and cast it to a double, then display. 
8. Operator Precedence 
• Objective: Explore how Java evaluates expressions. 
• Task: Evaluate and display the result of complex expressions. 
• Instructions: 
o Write expressions combining multiple operators, e.g., int result = 10 + 5 * 2;. 
o Display the result and explain the order of operations. 
9. Grade Calculator 
• Objective: Use conditional statements to determine grades. 
• Task: Assign grades based on marks entered by the user. 
• Instructions: 
o Prompt the user for marks out of 100. 
o Use if-else statements to assign grades: 
▪ 90-100: A 
▪ 80-89: B 
▪ 70-79: C 
▪ 60-69: D 
▪ Below 60: F 
o Display the assigned grade. 
10. Number Guessing Game 
• Objective: Implement loops and conditional logic. 
• Task: Create a game where the user guesses a randomly generated number. 
• Instructions: 
o Generate a random number between 1 and 100. 
o Prompt the user to guess the number. 
o Provide feedback if the guess is too high or too low. 
o Continue until the user guesses correctly. 
11. Factorial Calculator 
• Objective: Use loops to perform repetitive calculations. 
• Task: Calculate the factorial of a number entered by the user. 
• Instructions: 
o Prompt the user for a non-negative integer. 
o Use a for loop to calculate the factorial. 
o Display the result. 
12. Method Overloading 
• Objective: Understand method overloading in Java. 
• Task: Create multiple methods with the same name but different parameters. 
• Instructions: 
o Define methods named add that accept: 
▪ Two integers. 
▪ Two doubles. 
▪ Three integers. 
o Each method should return the sum of its parameters. 
o Call each method and display the results. 
13. Recursive Fibonacci 
• Objective: Implement recursion. 
• Task: Calculate the nth Fibonacci number using recursion. 
• Instructions: 
o Prompt the user for a positive integer n. 
o Define a recursive method fibonacci(int n) that returns the nth Fibonacci number. 
o Display the result. 
14. Array Sum and Average 
• Objective: Work with arrays and perform calculations. 
• Task: Calculate the sum and average of elements in an array. 
• Instructions: 
o Prompt the user to enter the number of elements. 
o Read the elements into an array. 
o Calculate and display the sum and average. 
15. String Reversal 
• Objective: Manipulate strings. 
• Task: Reverse a string entered by the user. 
• Instructions: 
o Prompt the user for a string. 
o Use a loop or StringBuilder to reverse the string. 
o Display the reversed string. 
16. Palindrome Checker 
• Objective: Combine string manipulation and conditional logic. 
• Task: Check if a string is a palindrome. 
• Instructions: 
o Prompt the user for a string. 
o Remove any non-alphanumeric characters and convert to lowercase. 
o Check if the string reads the same forwards and backwards. 
o Display the result. 
17. Class and Object Creation 
• Objective: Understand classes and objects. 
• Task: Create a Car class with attributes and methods. 
• Instructions: 
o Define attributes: make, model, year. 
o Implement a method displayDetails() to print car information. 
o Create objects of the Car class and call the method. 
18. Inheritance Example 
• Objective: Implement inheritance. 
• Task: Create a base class Animal and a subclass Dog. 
• Instructions: 
o Animal class should have a method makeSound(). 
o Dog class should override makeSound() to print "Bark". 
o Instantiate both classes and call their methods. 
19. Interface Implementation 
• Objective: Use interfaces in Java. 
• Task: Define an interface Playable with a method play(). 
• Instructions: 
o Implement the interface in classes Guitar and Piano. 
o Each class should provide its own implementation of play(). 
o Instantiate the classes and call the method. 
20. Try-Catch Example 
• Objective: Handle exceptions gracefully. 
• Task: Handle division by zero using try-catch. 
• Instructions: 
o Prompt the user for two integers. 
o Attempt to divide the first by the second. 
o Catch any ArithmeticException and display an appropriate message. 
21. Custom Exception 
• Objective: Create and use custom exceptions. 
• Task: Define a custom exception InvalidAgeException. 
• Instructions: 
o Throw InvalidAgeException if the user's age is less than 18. 
o Catch the exception and display a message. 
22. File Writing 
• Objective: Write data to a file. 
• Task: Write user input to a text file. 
• Instructions: 
o Prompt the user for a string. 
o Write the string to a file named output.txt. 
o Confirm that the data has been written. 
23. File Reading 
• Objective: Read data from a file. 
• Task: Read and display the contents of output.txt. 
• Instructions: 
o Open output.txt for reading. 
o Read each line and display it on the console. 
24. ArrayList Example 
• Objective: Use dynamic arrays. 
• Task: Manage a list of student names. 
• Instructions: 
o Create an ArrayList to store names. 
o Allow the user to add names to the list. 
o Display all names entered. 
25. HashMap Example 
• Objective: Use key-value pairs. 
• Task: Map student IDs to names. 
• Instructions: 
o Create a HashMap with Integer keys and String values. 
o Allow the user to add entries. 
o Retrieve and display a name based on an entered ID. 
26. Thread Creation 
• Objective: Implement multithreading. 
• Task: Create and run two threads that print messages. 
• Instructions: 
o Define a class that extends Thread or implements Runnable. 
o In the run() method, print a message multiple times. 
o Start both threads and observe the output. 
27. Lambda Expressions 
• Objective: Use functional programming features. 
• Task: Sort a list of strings using a lambda expression. 
• Instructions: 
o Create a List of strings. 
o Use Collections.sort() with a lambda to sort the list. 
o Display the sorted list. 
28. Stream API 
• Objective: Process collections using streams. 
• Task: Filter and display even numbers from a list. 
• Instructions: 
o Create a List of integers. 
o Use the Stream API to filter even numbers. 
o Collect and display the result. 
29. Records 
• Objective: Use the record keyword for immutable data structures (Java 16+). 
• Task: Create a record to represent a Person with name and age. 
• Instructions: 
o Define a record named Person. 
o Create instances and print them. 
o Use records in a List and filter based on age using Streams. 
30. Pattern Matching for switch (Java 21) 
• Objective: Simplify conditional logic with pattern matching in enhanced switch expressions. 
• Task: Determine the type of an object and respond accordingly. 
• Instructions: 
o Create a method that accepts Object as input. 
o Use a switch expression to check if the object is Integer, String, Double, etc. 
o Print a message based on the object’s type. 
31. Basic JDBC Connection 
• Objective: Connect Java with a relational database. 
• Task: Connect to a local MySQL/SQLite database and retrieve data. 
• Instructions: 
o Set up a database with a students table. 
o Write code to load the JDBC driver, create a connection, execute a SELECT query, and 
print results. 
32. Insert and Update Operations in JDBC 
• Objective: Perform insert/update SQL queries from Java. 
• Task: Add and modify student data using JDBC. 
• Instructions: 
o Create a StudentDAO class. 
o Implement methods to insert new records and update student details. 
o Use PreparedStatement for parameterized queries. 
33. Transaction Handling in JDBC 
• Objective: Use JDBC transactions. 
• Task: Simulate a money transfer between two accounts. 
• Instructions: 
o Create accounts table with balances. 
o Implement a transfer method with Connection.setAutoCommit(false). 
o Commit if both debit and credit succeed, else rollback. 
34. Create and Use Java Modules 
• Objective: Understand Java's module system. 
• Task: Create two modules: com.greetings and com.utils. 
• Instructions: 
o Define a module-info.java file in both modules. 
o Export a utility class from com.utils and use it in com.greetings. 
o Compile and run using the module path. 
35. TCP Client-Server Chat 
• Objective: Use Java sockets for TCP communication. 
• Task: Implement a simple TCP chat system. 
• Instructions: 
o Create a ServerSocket that listens for connections. 
o Accept client connections and use InputStream and OutputStream for two-way 
communication. 
o Run server and client in different terminals. 
36. HTTP Client API (Java 11+) 
• Objective: Make HTTP requests from Java. 
• Task: Fetch data from a public API (e.g., GitHub). 
• Instructions: 
o Use HttpClient and HttpRequest. 
o Print the response status and body. 
o Optional: Parse JSON response using Jackson or Gson. 
37. Using javap to Inspect Bytecode 
• Objective: Explore compiled .class files. 
• Task: Compile a Java class and inspect its bytecode using javap. 
• Instructions: 
o Create a class with a method. 
o Compile it and run javap -c ClassName. 
o Interpret the bytecode output. 
38. Decompile a Class File 
• Objective: Reverse engineer compiled Java bytecode. 
• Task: Use a tool like JD-GUI or CFR to decompile a .class file. 
• Instructions: 
o Write a simple Java program and compile it. 
o Open the .class file in a decompiler. 
o Analyze the decompiled source. 
39. Reflection in Java 
• Objective: Use Java Reflection API. 
• Task: Load a class and invoke methods dynamically. 
• Instructions: 
o Use Class.forName(), getDeclaredMethods(), and invoke() to call a method without 
directly referencing it in code. 
o Print the method names and parameters. 
40. Virtual Threads (Java 21) 
• Objective: Use lightweight threads for scalable concurrency. 
• Task: Launch 100,000 virtual threads that each print a message. 
• Instructions: 
o Use Thread.startVirtualThread(() -> { ... }). 
o Measure performance versus traditional threads. 
41. Executor Service and Callable 
• Objective: Use concurrency utilities. 
• Task: Execute multiple Callable tasks that return results. 
• Instructions: 
o Use Executors.newFixedThreadPool() and submit() to execute callables. 
o Collect results using Future.get(). 
