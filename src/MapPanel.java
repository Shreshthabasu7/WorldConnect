import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Uses Java Swing and AWT to display a world map
 * and show where friends and family are located.
 */

public class MapPanel extends JPanel {

    private Image mapImage;
    private ArrayList<Person> people;

    public MapPanel() {
        ImageIcon icon = new ImageIcon("images/WorldMap .png");
        mapImage = icon.getImage();
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
        repaint();
    }

    // Convert longitude into a pixel position based on the panel width.
    private int getXCoordinate(double longitude) {
        return (int) ((longitude + 180) / 360 * getWidth());
    }

    // Latitude is inverted because the y-axis in Swing increases downwards.
    private int getYCoordinate(double latitude) {
        return (int) ((90 - latitude) / 180 * getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //panels dimensions
        g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);

        for (Person person : people) {
            int x = getXCoordinate(person.getLongitude());
            int y = getYCoordinate(person.getLatitude());

            if (TimeZoneCalc.isAvailable(person)) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.RED);
            }

            // Subtract half the diameter to center the dot
            // on the person's location.
            g.fillOval(x - 5, y - 5, 10, 10);

            g.setColor(Color.BLACK);
            g.drawString(person.getName(), x + 8, y);
        }
    }
}
