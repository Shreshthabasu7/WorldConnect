
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

                              
        JFrame frame = new JFrame("WorldConnect");

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MapPanel map = new MapPanel();

        JPanel inputPanel = new JPanel();

        JTextField nameField = new JTextField(10);
        JTextField cityField = new JTextField(10);
        JButton addButton = new JButton("Add Contact");

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("City:"));
        inputPanel.add(cityField);

        inputPanel.add(addButton);

        frame.setLayout(new BorderLayout());
        frame.add(map, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText().trim();
                String city = cityField.getText().trim();

                // check the input before making an API request
                // to avoid unnecessary network calls.

                if (name.isEmpty() || city.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter both a name and a city.");
                    return;
                }

                try {
                    Person person = Geocoding.createPerson(name, city);
                    map.addPerson(person);

                    nameField.setText("");
                    cityField.setText("");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Unable to find location. Check the city or internet connection.");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}