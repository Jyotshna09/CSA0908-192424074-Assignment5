import java.io.*;

public class BusPassStore {

    static final String FILE = "Task01_FileFormatDesign/input/bus_passes.txt";

    public static void main(String[] args) {
        listAll();
        findPass("BP102");
        listByRoute(12);
    }

    static void listAll() {
        System.out.println("\nALL BUS PASSES");

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                display(line);
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    static void findPass(String id) {
        System.out.println("\nSEARCH RESULT: " + id);

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 7 && data[0].equals(id)) {
                    display(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Pass not found.");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    static void listByRoute(int route) {
        System.out.println("\nPASSES ON ROUTE " + route);

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 7) {
                    try {
                        if (Integer.parseInt(data[3]) == route) {
                            display(line);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid route data.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    static void display(String line) {
        String[] data = line.split("\\|", -1);

        if (data.length == 7) {
            System.out.println(
                "ID: " + data[0] +
                " | Name: " + data[2] +
                " | Route: " + data[3] +
                " | Amount: " + data[6]
            );
        } else {
            System.out.println("Damaged record: " + line);
        }
    }
}