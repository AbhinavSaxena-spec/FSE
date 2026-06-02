// Exercise 32: Insert and Update Operations in JDBC
// Requires: sqlite-jdbc jar (same setup as Ex31)
import java.sql.*;

public class Ex32_JDBCInsertUpdate {

    private static final String URL = "jdbc:sqlite:school.db";

    // DAO class
    static class StudentDAO {

        void insert(int id, String name, String grade) throws SQLException {
            String sql = "INSERT OR REPLACE INTO students(id, name, grade) VALUES(?,?,?)";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, grade);
                int rows = ps.executeUpdate();
                System.out.println("Inserted/replaced " + rows + " row: " + name);
            }
        }

        void update(int id, String newGrade) throws SQLException {
            String sql = "UPDATE students SET grade = ? WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, newGrade);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                System.out.println("Updated " + rows + " row(s) for id=" + id);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // Ensure table exists (run Ex31 first, or create inline)
        try (Connection c = DriverManager.getConnection(URL);
             Statement  s = c.createStatement()) {
            s.execute("CREATE TABLE IF NOT EXISTS students "
                    + "(id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
        }

        StudentDAO dao = new StudentDAO();
        dao.insert(4, "Diana", "C");
        dao.insert(5, "Eve",   "B");
        dao.update(4, "A");     // Diana improved!
    }
}
