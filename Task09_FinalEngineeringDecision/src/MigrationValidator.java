import java.io.*;
import java.util.*;

public class MigrationValidator {

    static final String INPUT =
        "Task09_FinalEngineeringDecision/input/bus_passes.txt";

    static final String OUTPUT =
        "Task09_FinalEngineeringDecision/output/MigrationReport.txt";

    public static void main(String[] args) {

        int valid = 0;
        int invalid = 0;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(INPUT));
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))
        ) {
            writer.write("BUS PASS MIGRATION VALIDATION REPORT");
            writer.newLine();
            writer.write("-----------------------------------");
            writer.newLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split("\\|", -1);

                if (fields.length == 7 && !fields[0].isBlank()
                        && !fields[1].isBlank()
                        && !fields[2].isBlank()) {

                    valid++;
                    writer.write("VALID: " + fields[0]);
                } else {
                    invalid++;
                    writer.write("INVALID: " + line);
                }

                writer.newLine();
            }

            writer.newLine();
            writer.write("Valid records: " + valid);
            writer.newLine();
            writer.write("Invalid records: " + invalid);
            writer.newLine();
            writer.write("Migration validation completed.");

            System.out.println("Migration validation completed.");
            System.out.println("Valid records: " + valid);
            System.out.println("Invalid records: " + invalid);
            System.out.println("Report saved to: " + OUTPUT);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}