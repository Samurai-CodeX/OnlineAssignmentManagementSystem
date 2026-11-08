import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;

public class DatabaseConnectionCheck {
    public static void main(String[] args) throws Exception {
        Path database = Path.of("data", "assignment_management.db").toAbsolutePath();
        Files.createDirectories(database.getParent());

        try (var connection = DriverManager.getConnection("jdbc:sqlite:" + database);
                var statement = connection.createStatement();
                var result = statement.executeQuery("SELECT sqlite_version()")) {
            if (result.next()) {
                System.out.println("Connected to SQLite " + result.getString(1));
                System.out.println("Database file: " + database);
            }
        }
    }
}
