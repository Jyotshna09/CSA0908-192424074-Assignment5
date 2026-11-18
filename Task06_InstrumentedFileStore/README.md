# Task B1 – Instrumented File Store

## Objective
Implement bus-pass file storage and buffered record processing.

## Files
- src/InstrumentedFileStore.java – Add, list, search and count operations.
- input/bus_passes.txt – Sample bus-pass records.
- design/PerformanceAnalysis.md – Complexity and performance observations.

## Execution
Compile:
javac Task06_InstrumentedFileStore/src/*.java

Run:
java -cp Task06_InstrumentedFileStore/src InstrumentedFileStore

## Result
The program displays bus-pass records, searches for existing and missing IDs, and measures buffered reading time.