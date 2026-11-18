# Task A3 – Data Access Object Pattern

## A3.1 – Common Pattern

The repeated steps in StudentDB, CourseDB and MarksDB are:

1. Open database connection.
2. Prepare and execute SQL query.
3. Read ResultSet.
4. Convert rows into Java objects.
5. Close database resources.

The table names, columns and SQL conditions differ.

## A3.2 – Generic DAO Interface

The Dao<T,K> interface provides:

- insert()
- findById()
- findAll()
- update()
- delete()

StudentDao implements Dao<Student,Integer> and performs
database operations for Student objects.

## A3.3 – Object-to-Table Mapping

| Student Field | Database Column | Type |
|---|---|---|
| id | id | INT |
| name | name | VARCHAR |
| email | email | VARCHAR |

The id column is the primary key.

## Alternative – SQL in Service or GUI

If SQL is directly written in service or GUI classes,
database logic becomes duplicated.

When a column is renamed, several classes may need changes.
With DAO, the change is mainly handled in StudentDao.

## Complexity Comparison

Both approaches have the same database operation complexity.

- Search by primary key: approximately O(1) with an index.
- Reading all students: O(n).
- Extra application memory: O(n) when all records are loaded.

DAO improves maintainability but does not automatically
make database queries faster.

## Conclusion

The DAO pattern separates database operations from
application logic and improves code reuse and maintenance.