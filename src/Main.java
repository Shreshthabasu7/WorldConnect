import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            String response = Geocoding.searchLocation("New York");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
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