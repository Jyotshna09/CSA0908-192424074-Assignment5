# Performance Analysis – Instrumented File Store

## Operations
- Add: Appends a record using BufferedWriter.
- List: Reads all records using BufferedReader.
- Search: Sequentially searches for a pass ID.
- Validation: Skips records that do not contain seven fields.
- Counting: Counts records using buffered reading.

## Complexity
- Add: O(1) per appended record.
- List: O(n).
- Search: O(n).
- Count: O(n).

## Observation
Buffered I/O reduces repeated low-level read operations and is suitable for processing larger files.

## Limitation
Sequential file search becomes slower as the number of records increases. A database index is preferable for large datasets.