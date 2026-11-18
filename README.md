# CSA09 – Assignment 5: Data Persistence Engineering

**Student Name:** Jyotshna Singamsetty  
**Register Number:** 192424074  
**Department:** Artificial Intelligence and Data Science  
**Batch:** 2024–2028  
**Subject:** Programming in Java  
**Assignment:** Assignment 5 – CO5  
**Topic:** Data Persistence Engineering – Files and Databases

---

## 1. Objective

The objective of this assignment is to understand and implement Java data persistence techniques using file handling, buffered I/O, object serialization, DAO architecture, JDBC transactions, SQL security, batch processing and database migration.

## 2. Repository Structure

| Task | Topic |
|---|---|
| Task 01 | File Format Design |
| Task 02 | Buffered I/O |
| Task 03 | DAO Design |
| Task 04 | Object Serialization |
| Task 05 | Transactions and SQL Injection |
| Task 06 | Instrumented File Store |
| Task 07 | Adversarial Inputs |
| Task 08 | JDBC Performance and Batch Processing |
| Task 09 | Final Engineering Decision |

Each task contains source code, input data, output or report files, design documentation and a task-specific README where applicable.

## 3. Technologies Used

- Java
- Java File I/O
- BufferedReader and BufferedWriter
- Object Serialization
- JDBC
- SQL and MySQL
- PreparedStatement
- Git and GitHub
- Visual Studio Code

## 4. Concepts Covered

### File Handling
Designed text and binary file formats and implemented file operations for bus-pass records.

### Buffered I/O
Compared buffered and unbuffered reading and studied performance and memory usage.

### DAO Architecture
Designed a generic DAO interface and JDBC-based Student DAO operations.

### Serialization
Implemented serialization and deserialization of Hostel, Room and Resident objects. Used transient fields for sensitive or non-serializable data.

### Transactions and Security
Studied transaction management using commit and rollback and SQL injection prevention using PreparedStatement.

### File Store Implementation
Implemented adding, searching, listing and counting bus-pass records using buffered file operations.

### Adversarial Input Handling
Demonstrated unsafe and parameterized SQL query construction and validated malformed file records.

### JDBC Performance
Prepared a batch insertion program using PreparedStatement and SQL schema for database testing.

### Migration and Engineering Decision
Implemented file-record validation and report generation and documented a database migration strategy.

## 5. Execution

Compile and run the independent Java demonstrations from the repository root.

Example:

```powershell
javac Task06_InstrumentedFileStore\src\*.java
java -cp Task06_InstrumentedFileStore\src InstrumentedFileStore
```

Refer to individual task README files for their execution instructions.

## 6. Conclusion

This assignment provides practical understanding of Java data persistence methods. It demonstrates how file handling, serialization and database technologies can be used to store, retrieve, validate and manage data.

A relational database is recommended for larger applications that require structured queries, transaction management, indexing and concurrent access.

## 7. Note on Execution Evidence

Database-dependent JDBC programs require a configured MySQL database and JDBC driver. Database benchmarks and migration results should be recorded only after actual execution. Illustrative outputs are not treated as measured results.