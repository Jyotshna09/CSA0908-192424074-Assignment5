import java.io.*;

public class InputSecurityDemo {

    static final String FILE =
        "Task07_AdversarialInputs/input/bus_passes.txt";

    static void checkUnsafeLogin(String username) {
        String query = "SELECT * FROM Users WHERE username = '"
                + username + "'";

        System.out.println("Unsafe SQL query:");
        System.out.println(query);
    }

    static void checkSafeLogin(String username) {
        String query = "SELECT * FROM Users WHERE username = ?";

        System.out.println("\nSafe PreparedStatement query:");
        System.out.println(query);
        System.out.println("Username supplied as a parameter: " + username);
    }

    static void validateRecords() {
        int valid = 0;
        int invalid = 0;

        System.out.println("\nBUS-PASS VALIDATION");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);

                if (fields.length == 7) {
                    valid++;
                    System.out.println("VALID: " + fields[0]);
                } else {
                    invalid++;
                    System.out.println("INVALID RECORD SKIPPED: " + line);
                }
            }

            System.out.println("\nValid records: " + valid);
            System.out.println("Invalid records: " + invalid);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String attackInput = "' OR '1'='1";

        System.out.println("SQL INJECTION DEMONSTRATION");
        checkUnsafeLogin(attackInput);
        checkSafeLogin(attackInput);

        validateRecords();
    }
}