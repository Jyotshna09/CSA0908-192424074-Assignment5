# Task 2 – Buffered I/O

## Objective
Compare unbuffered and buffered file reading.

## Technologies
- Java FileInputStream
- Java BufferedInputStream
- BufferedOutputStream
- System.nanoTime()

## Run

From the main repository folder:

javac Task02_BufferedIO/src/BufferedLineCounter.java

java -cp Task02_BufferedIO/src BufferedLineCounter

## Result
The program generates 1 MB, 10 MB and 50 MB files and compares
line counts and execution times using both approaches.

## Conclusion
Buffered input reduces repeated low-level read operations and
uses a fixed-size buffer.