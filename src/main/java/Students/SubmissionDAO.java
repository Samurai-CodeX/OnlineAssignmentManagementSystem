package Students;

import java.sql.SQLException;

@FunctionalInterface
public interface SubmissionDAO {
    void save(int assignmentId, int studentId, String answer) throws SQLException;
}
