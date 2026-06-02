// Exercise 31: Basic JDBC Connection (SQLite)
// Dependency: sqlite-jdbc jar on classpath, e.g.:
//   javac -cp sqlite-jdbc.jar Ex31_JDBCBasic.java
//   java  -cp .:sqlite-jdbc.jar Ex31_JDBCBasic
import java.sql.*;

public class Ex31_JDBCBasic {
    private static final String URL = "jdbc:sqlite:school.db";

    public static void main(String[] args) {
        // 1. Set up: create table and seed data
        try (Connection conn = DriverManager.getConnection(URL);
             Statement  stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS students ("
                       + "id INTEGER PRIMARY KEY, name TEXT NOT NULL, grade TEXT)");
            stmt.execute("DELETE FROM students"); // clean slate for demo
            stmt.execute("INSERT INTO students VALUES (1,'Alice','A')");
            stmt.execute("INSERT INTO students VALUES (2,'Bob','B')");
            stmt.execute("INSERT INTO students VALUES (3,'Carol','A')");

            System.out.println("Table created and seeded.");
        } catch (SQLException e) {
            System.err.println("Setup error: " + e.getMessage());
            return;
        }

        // 2. Query data
        String sql = "SELECT * FROM students";
        try (Connection  conn = DriverManager.getConnection(URL);
             Statement   stmt = conn.createStatement();
             ResultSet   rs   = stmt.executeQuery(sql)) {

            System.out.println("\nStudents:");
            System.out.printf("%-5s %-15s %s%n", "ID", "Name", "Grade");
            System.out.println("-".repeat(25));
            while (rs.next()) {
                System.out.printf("%-5d %-15s %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
            }
        } catch (SQLException e) {
            System.err.println("Query error: " + e.getMessage());
        }
    }
}
