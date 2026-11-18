# Final Engineering Decision

## 1. File Storage
File storage is suitable for small datasets and simple applications. It is easy to implement but becomes difficult to manage with concurrent users and large records.

## 2. Serialization
Serialization is useful for saving and restoring Java object graphs. However, it is less suitable for long-term data exchange and database querying.

## 3. Database Storage
A relational database is recommended for large bus-pass systems. It supports structured queries, transactions, constraints, indexing and concurrent access.

## 4. Migration Strategy
1. Read records from the existing file.
2. Validate each record.
3. Convert valid records into database objects.
4. Insert records using PreparedStatement batches.
5. Use transactions for consistency.
6. Compare source and destination record counts.
7. Generate a migration report.

## 5. Metadata
DatabaseMetaData can be used to inspect tables, columns, database versions and supported features.

## 6. Final Recommendation
For a university bus-pass management system, a relational database is the preferred long-term solution. Files can be retained for backup and data exchange.