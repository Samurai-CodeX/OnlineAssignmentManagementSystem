import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;




public class MainWindow {

    public static void main (String [] args){
     SwingUtilities.invokeLater(MainWindow::showWindow);   
    }

    private static void showWindow(){
        JFrame window = new JFrame("SSTU AssignDesk");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Welcome to SSTU AssignDesk",
        SwingConstants.CENTER
    );

    heading.setFont(heading.getFont().deriveFont(Font.BOLD, 22f));
    window.add(heading);
    window.setSize(640, 400);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    }
}
