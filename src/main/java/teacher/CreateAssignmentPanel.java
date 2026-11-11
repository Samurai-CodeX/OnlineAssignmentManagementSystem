package teacher;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateAssignmentPanel extends JPanel {

    public CreateAssignmentPanel() {
        super(new BorderLayout(0, 12));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel details = new JPanel(new GridLayout(0, 1, 0, 4));
        details.add(new JLabel("Assignment Title:"));
        details.add(new JTextField());
        details.add(new JLabel("Deadline (YYYY-MM-DD HH:MM"));
        details.add(new JTextField());

        JTextArea description = new JTextArea(5, 30);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        JPanel descriptionPanel = new JPanel(new BorderLayout(0, 4));
        descriptionPanel.add(new JLabel("Description"), BorderLayout.NORTH);
        descriptionPanel.add(new JScrollPane(description), BorderLayout.CENTER);

        add(details, BorderLayout.NORTH);
        add(descriptionPanel, BorderLayout.CENTER);
        add(new JButton("Save Assignment"), BorderLayout.SOUTH);
    }  
}
