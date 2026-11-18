# Task A2 – Buffered I/O Analysis

## A2.1 – Predict the Cost

For a 50 MB file:

50 × 1024 × 1024 = 52,428,800 bytes.

Reading one byte at a time requires approximately 52,428,800
read calls at the Java stream level. This causes high overhead
because of repeated method and native I/O operations.

## A2.2 – Buffered Reading

A BufferedInputStream reads a block of data into memory and
serves individual byte requests from that buffer.

For an 8 KB buffer:

52,428,800 / 8,192 = approximately 6,400 block refills.

This greatly reduces native read operations.

## A2.3 – When Buffering Does Not Help

Buffering gives little benefit when the data is already available
in memory or when the application reads only a very small file once.

## Alternative – Files.readAllLines()

Files.readAllLines() loads all lines into memory.

- Time complexity: O(n), where n is file size.
- Space complexity: O(n).
- Buffered streaming: O(n) time and O(b) extra memory,
  where b is buffer size.

For a 50 MB file, readAllLines() may consume considerably more
than 50 MB because it stores separate String objects and a list.

Streaming is suitable for large files. readAllLines() is suitable
for smaller files that comfortably fit in memory.

## Conclusion

Buffered streaming provides a good balance between speed and
memory usage when processing large attendance logs.