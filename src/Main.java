import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WorldConnect");

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to WorldConnect!");
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}