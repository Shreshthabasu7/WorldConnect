import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    private Image mapImage;

    public MapPanel() {
        ImageIcon icon = new ImageIcon("images/WorldMap .png");
        mapImage = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
    }
}
