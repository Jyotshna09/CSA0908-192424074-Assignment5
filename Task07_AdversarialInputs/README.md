# Task B2 – Adversarial Inputs

## Objective
Demonstrate SQL injection risks and validate damaged file records.

## Files
- InputSecurityDemo.java – Unsafe/safe query demonstration and file validation.
- input/bus_passes.txt – Valid and malformed records.
- SecurityAnalysis.md – Security explanation.

## Execution

Compile:
javac Task07_AdversarialInputs/src/*.java

Run:
java -cp Task07_AdversarialInputs/src InputSecurityDemo

## Result
The program displays an unsafe SQL query, a parameterized query, and the results of validating bus-pass records.

## Note
This is a query-construction demonstration, not a live database login test. Actual JDBC login testing requires a database connection.