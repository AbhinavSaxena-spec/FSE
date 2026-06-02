// Exercise 33: Transaction Handling in JDBC – Money Transfer
// Requires: sqlite-jdbc jar
import java.sql.*;

public class Ex33_JDBCTransaction {

    private static final String URL = "jdbc:sqlite:bank.db";

    static void setup() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement  stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts "
                       + "(id INTEGER PRIMARY KEY, name TEXT, balance REAL)");
            stmt.execute("DELETE FROM accounts");
            stmt.execute("INSERT INTO accounts VALUES (1,'Alice', 1000.0)");
            stmt.execute("INSERT INTO accounts VALUES (2,'Bob',   500.0)");
        }
    }

    static void printBalances(String header) throws SQLException {
        System.out.println("\n" + header);
        try (Connection conn = DriverManager.getConnection(URL);
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery("SELECT * FROM accounts")) {
            while (rs.next())
                System.out.printf("  %-8s: $%.2f%n", rs.getString("name"), rs.getDouble("balance"));
        }
    }

    /**
     * Transfers {@code amount} from account {@code fromId} to {@code toId}.
     * Uses a transaction: rolls back if either update fails.
     */
    static void transfer(int fromId, int toId, double amount) throws SQLException {
        String debit  = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false);          // start transaction
            try (PreparedStatement psDebit  = conn.prepareStatement(debit);
                 PreparedStatement psCredit = conn.prepareStatement(credit)) {

                psDebit.setDouble(1, amount); psDebit.setInt(2, fromId);
                int r1 = psDebit.executeUpdate();

                // Simulate a possible failure (e.g., check balance)
                try (PreparedStatement check = conn.prepareStatement(
                        "SELECT balance FROM accounts WHERE id = ?")) {
                    check.setInt(1, fromId);
                    ResultSet rs = check.executeQuery();
                    if (rs.next() && rs.getDouble("balance") < 0)
                        throw new SQLException("Insufficient funds!");
                }

                psCredit.setDouble(1, amount); psCredit.setInt(2, toId);
                int r2 = psCredit.executeUpdate();

                conn.commit();
                System.out.printf("Transfer of $%.2f succeeded (%d+%d rows updated).%n", amount, r1, r2);
            } catch (SQLException ex) {
                conn.rollback();
                System.out.println("Transfer failed, rolled back: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        setup();
        printBalances("Initial balances:");
        transfer(1, 2, 300.0);   // Alice → Bob: $300
        printBalances("After transfer:");
        transfer(2, 1, 900.0);   // Bob → Alice: $900 (will fail — insufficient funds)
        printBalances("After failed transfer:");
    }
}
