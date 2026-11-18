import java.sql.*;
import java.io.*;

public class PassLoader {

    static final String URL = "jdbc:mysql://localhost:3306/BusPassDB";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        String file = "Task08_JDBCPerformance/input/passes.csv";

        String sql = "INSERT INTO BusPass VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            con.setAutoCommit(false);

            String line;
            reader.readLine(); // Skip header

            int count = 0;
            long start = System.nanoTime();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 5) {
                    System.out.println("Invalid row skipped: " + line);
                    continue;
                }

                ps.setString(1, data[0]);
                ps.setString(2, data[1]);
                ps.setString(3, data[2]);
                ps.setInt(4, Integer.parseInt(data[3]));
                ps.setDouble(5, Double.parseDouble(data[4]));

                ps.addBatch();
                count++;

                if (count % 100 == 0) {
                    ps.executeBatch();
                }
            }

            ps.executeBatch();
            con.commit();

            long end = System.nanoTime();

            System.out.println("Records inserted: " + count);
            System.out.println("Batch insertion completed.");
            System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        } catch (Exception e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}