import java.io.*;
import java.nio.file.*;

public class InstrumentedFileStore {

    static final String FILE =
        "Task06_InstrumentedFileStore/input/bus_passes.txt";

    static void addPass(String record) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(record);
            writer.newLine();
        }
        System.out.println("Bus pass added successfully.");
    }

    static void listPasses() throws IOException {
        System.out.println("\nALL BUS PASSES");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);

                if (fields.length == 7) {
                    System.out.println(line);
                } else {
                    System.out.println("Invalid record skipped: " + line);
                }
            }
        }
    }

    static void findPass(String passId) throws IOException {
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);

                if (fields.length == 7 && fields[0].equals(passId)) {
                    System.out.println("\nSEARCH RESULT: " + line);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("\nBus pass not found: " + passId);
        }
    }

    static void countLines() throws IOException {
        long count = 0;
        long start = System.nanoTime();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while (reader.readLine() != null) {
                count++;
            }
        }

        long end = System.nanoTime();

        System.out.println("\nTotal records: " + count);
        System.out.println("Buffered read time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        try {
            listPasses();
            findPass("BP102");
            findPass("BP999");
            countLines();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}