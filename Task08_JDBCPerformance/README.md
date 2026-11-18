# Task B3 – JDBC Performance and Batch Processing

## Objective
Compare JDBC execution methods and implement batch insertion.

## Files
- PassLoader.java – Batch insertion using PreparedStatement.
- passes.csv – Sample bus-pass records.
- schema.sql – Database and table creation.
- JDBCAnalysis.md – Performance comparison.

## Execution
1. Create the BusPassDB database using schema.sql.
2. Configure MySQL credentials in PassLoader.java.
3. Add the MySQL JDBC driver to the classpath.
4. Compile and execute PassLoader.

## Result
The program inserts CSV records using PreparedStatement batch processing and reports execution time.