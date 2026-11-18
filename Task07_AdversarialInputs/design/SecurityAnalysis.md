# Adversarial Input and Security Analysis

## 1. SQL Injection

SQL injection occurs when untrusted input is joined directly with SQL statements.

Example attack input:
' OR '1'='1

An unsafe query may allow the input to change the query's meaning.

## 2. Safe Query

PreparedStatement uses placeholders (?) and binds user input separately.

This prevents user input from being interpreted as SQL syntax.

## 3. Damaged File Records

The bus-pass file contains valid and invalid records.

The program checks whether every record contains seven fields.
Invalid records are skipped and counted.

## 4. Security Recommendations
- Use PreparedStatement for database queries.
- Validate all input fields.
- Use secure password hashing.
- Do not display sensitive database errors to users.
- Log invalid records for investigation.

## 5. Conclusion

Parameterized SQL queries reduce SQL injection risk. File validation prevents malformed records from being processed as valid bus-pass data.