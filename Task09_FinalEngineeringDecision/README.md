# Task B4 – Final Engineering Decision

## Objective
Validate bus-pass records and prepare a migration report for moving file data to a database.

## Files
- MigrationValidator.java – Validates input records and generates a report.
- bus_passes.txt – Sample source records.
- MigrationReport.txt – Generated validation report.
- EngineeringDecision.md – Storage and migration recommendations.

## Execution

Compile:
javac Task09_FinalEngineeringDecision/src/*.java

Run:
java -cp Task09_FinalEngineeringDecision/src MigrationValidator

## Result
The program validates source records and generates a report containing valid and invalid record counts.

## Note
The program demonstrates validation and reporting. Actual database migration and DatabaseMetaData inspection require a configured JDBC database.