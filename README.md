# Online Assignment Management System

A Java project for managing academic assignments. The goal is to give teachers a place to publish assignments and review submissions, and students a place to view deadlines and submit their work.

## Current Status

The Maven project is set up, and the application can connect to a local SQLite database. The `DatabaseConnectionCheck` class verifies the database connection.

## Planned Features

- **Teachers** can create assignments, set deadlines, and review submissions.
- **Students** can view assignments, check deadlines, and submit their work.
- **Grading and feedback** will allow teachers to record grades and share feedback with students.

## Tech Stack

| Technology | Purpose |
| --- | --- |
| Java | Application development |
| Maven | Build and dependency management |
| SQLite | Local database |
| JDBC | Database connectivity |

## Getting Started

Install a JDK compatible with the Java version configured in `pom.xml`. Clone the repository and open the project folder in your terminal.

### Verify the Database Connection

Run this command from the project root on macOS or Linux.

```bash
./mvnw compile exec:java '-Dexec.mainClass=DatabaseConnectionCheck'
```

This command compiles the project and runs the SQLite connection check.

