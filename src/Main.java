import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Alice", "Kolkata",
                            "Asia/Kolkata", 22.57, 88.36);

        Person p2 = new Person("Bob", "Chicago",
                            "America/Chicago", 41.88, -87.63);

        System.out.println(p1.getCity() + ": " + TimeZoneCalc.getLocalTime(p1));
        System.out.println(p2.getCity() + ": " + TimeZoneCalc.getLocalTime(p2));
                              
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