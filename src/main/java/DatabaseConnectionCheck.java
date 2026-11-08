import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionCheck {
    public static void main(String[] args) throws Exception {
        Path database = Path.of("data", "assignment_management.db").toAbsolutePath();
        Files.createDirectories(database.getParent());

        try (var connection = DriverManager.getConnection("jdbc:sqlite:" + database);
                var statement = connection.createStatement()) {

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS demo_assignments (
                        id INTEGER PRIMARY KEY,
                        title TEXT NOT NULL
                    )
                    """);

            statement.executeUpdate("""
                    INSERT INTO demo_assignments (id, title)
                    VALUES (1, 'Sample Assignment')
                    ON CONFLICT (id) DO NOTHING
                    """);

            try (var result = statement.executeQuery(
                    "SELECT id, title FROM demo_assignments WHERE id = 1")) {
                if (!result.next()) {
                    throw new SQLException("Sample assignment could not be read.");
                }

                System.out.println("Sample assignment: " + result.getInt("id")
                        + " | " + result.getString("title"));
            }
        }

        System.out.println("Database file: " + database);
    }
}