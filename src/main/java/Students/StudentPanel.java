package Students;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

public class StudentPanel extends JPanel {

  private final JComboBox<String> assignmentBox = new JComboBox<>();
    private final JTextArea descriptionArea = new JTextArea(4, 30);
    private final JTextArea answerArea = new JTextArea(8, 30);

    public StudentPanel(
            int studentId,
            List<Assignment> assignments,
            SubmissionDAO submissionDAO
    ) {
        super(new BorderLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        for (Assignment assignment : assignments) {
            assignmentBox.addItem(
                assignment.getId() + " - " + assignment.getTitle()
            );
        }

        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);

        JScrollPane descriptionPane = new JScrollPane(descriptionArea);
        descriptionPane.setBorder(
            BorderFactory.createTitledBorder("Assignment Details")
        );

        JScrollPane answerPane = new JScrollPane(answerArea);
        answerPane.setBorder(BorderFactory.createTitledBorder("Your Answer"));

        JPanel content = new JPanel(new GridLayout(2, 1, 0, 8));
        content.add(descriptionPane);
        content.add(answerPane);

        JButton submitButton = new JButton("Submit");
        submitButton.setEnabled(!assignments.isEmpty());

        add(assignmentBox, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        assignmentBox.addActionListener(event -> {
            int index = assignmentBox.getSelectedIndex();
            descriptionArea.setText(assignments.get(index).getDescription());
        });

        if (assignments.isEmpty()) {
            descriptionArea.setText("No assignments available.");
        } else {
            descriptionArea.setText(assignments.get(0).getDescription());
        }

        submitButton.addActionListener(event -> {
            String answer = answerArea.getText().trim();

            if (answer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please write your answer.");
                return;
            }

            Assignment selected = assignments.get(assignmentBox.getSelectedIndex());

            try {
                submissionDAO.save(selected.getId(), studentId, answer);
                answerArea.setText("");
                JOptionPane.showMessageDialog(this, "Assignment submitted.");
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(
                    this,
                    "Could not save the submission: " + exception.getMessage(),
                    "Submission Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}

  

