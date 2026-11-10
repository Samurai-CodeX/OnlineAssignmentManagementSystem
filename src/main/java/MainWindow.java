import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Students.Assignment;
import Students.StudentPanel;

public class MainWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::showWindow);
    }

    private static void showWindow() {
        JFrame window = new JFrame("SSTU AssignDesk");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Welcome to SSTU AssignDesk", SwingConstants.CENTER);
        heading.setFont(heading.getFont().deriveFont(Font.BOLD, 22f));

        List<Assignment> assignments = List.of(
            new Assignment(1, "Essay Draft", "Write a short reflection on the assigned topic."),
            new Assignment(2, "Research Notes", "Summarize your findings and include citations.")
        );

        StudentPanel studentPanel = new StudentPanel(101, assignments, (assignmentId, studentId, answer) -> {
            System.out.println("Submitted assignment " + assignmentId + " by student " + studentId + ": " + answer);
        });

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.add(heading, BorderLayout.NORTH);
        content.add(studentPanel, BorderLayout.CENTER);

        window.setContentPane(content);
        window.setSize(640, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
