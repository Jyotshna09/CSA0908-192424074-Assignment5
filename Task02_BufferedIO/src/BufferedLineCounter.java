import java.io.*;

public class BufferedLineCounter {

    static void createFile(String path, int sizeMB) throws IOException {
        long target = sizeMB * 1024L * 1024L;
        byte[] data = new byte[8192];

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 80 == 79 ? '\n' : 'A');
        }

        try (BufferedOutputStream out =
                 new BufferedOutputStream(new FileOutputStream(path))) {
            long written = 0;

            while (written < target) {
                int amount = (int) Math.min(data.length, target - written);
                out.write(data, 0, amount);
                written += amount;
            }
        }
    }

    static long countUnbuffered(String path) throws IOException {
        long lines = 0;

        try (FileInputStream in = new FileInputStream(path)) {
            int ch;
            while ((ch = in.read()) != -1) {
                if (ch == '\n') lines++;
            }
        }
        return lines;
    }

    static long countBuffered(String path) throws IOException {
        long lines = 0;

        try (BufferedInputStream in =
                 new BufferedInputStream(new FileInputStream(path))) {
            int ch;
            while ((ch = in.read()) != -1) {
                if (ch == '\n') lines++;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        int[] sizes = {1, 10, 50};

        for (int size : sizes) {
            String path = "Task02_BufferedIO/input/attendance_" + size + "MB.txt";

            System.out.println("\nTesting " + size + " MB file...");
            createFile(path, size);

            long start = System.nanoTime();
            long unbufferedLines = countUnbuffered(path);
            long unbufferedTime = System.nanoTime() - start;

            start = System.nanoTime();
            long bufferedLines = countBuffered(path);
            long bufferedTime = System.nanoTime() - start;

            System.out.println("Unbuffered lines: " + unbufferedLines);
            System.out.println("Buffered lines: " + bufferedLines);
            System.out.printf("Unbuffered time: %.2f ms%n",
                    unbufferedTime / 1_000_000.0);
            System.out.printf("Buffered time: %.2f ms%n",
                    bufferedTime / 1_000_000.0);
        }
    }
}