import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Person p = Geocoding.createPerson("Alice", "New York");

            System.out.println(p.getLatitude());
            System.out.println(p.getLongitude());
            System.out.println(p.getTimeZone());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

                              
        JFrame frame = new JFrame("WorldConnect");

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MapPanel map = new MapPanel();
        frame.add(map);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}