# Transaction and SQL Injection Analysis

## 1. Wallet Transfer

A transaction transfers money between two wallets.

Example: Transfer Rs.500 from wallet 101 to wallet 102.

### Steps
1. Disable auto-commit.
2. Deduct Rs.500 from the source wallet.
3. Add Rs.500 to the destination wallet.
4. Commit if both operations succeed.
5. Roll back if any operation fails.

### ACID Properties
- Atomicity: Both updates succeed or neither succeeds.
- Consistency: Database rules remain valid.
- Isolation: Concurrent transactions do not interfere incorrectly.
- Durability: Committed changes are saved.

## 2. SQL Injection

SQL injection occurs when user input is directly added to an SQL query.

Unsafe example:
`SELECT * FROM Users WHERE username = '` + username + `'`

An attacker may enter SQL commands as input.

### Prevention
- Use PreparedStatement.
- Pass user input through parameters.
- Avoid building SQL queries using string concatenation.
- Store passwords using secure password hashing.

## 3. Auto-Commit

Auto-commit saves each SQL statement independently. This can cause incomplete transfers.

Manual transactions provide control through commit and rollback.

## 4. Conclusion

Transactions protect data consistency during wallet transfers. PreparedStatement helps prevent SQL injection by separating SQL instructions from user input.