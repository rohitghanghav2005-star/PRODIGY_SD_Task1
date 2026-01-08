import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {

    JTextField tempField;
    JComboBox<String> unitBox;
    JTextArea resultArea;
    JButton convertBtn;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input label and field
        add(new JLabel("Enter Temperature:"));
        tempField = new JTextField(10);
        add(tempField);

        // Unit selection
        add(new JLabel("Select Unit:"));
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        unitBox = new JComboBox<>(units);
        add(unitBox);

        // Convert button
        convertBtn = new JButton("Convert");
        convertBtn.addActionListener(this);
        add(convertBtn);

        // Result area
        resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double temp = Double.parseDouble(tempField.getText());
            String unit = (String) unitBox.getSelectedItem();
            double c, f, k;

            if (unit.equals("Celsius")) {
                c = temp;
                f = (c * 9 / 5) + 32;
                k = c + 273.15;
            } 
            else if (unit.equals("Fahrenheit")) {
                f = temp;
                c = (f - 32) * 5 / 9;
                k = c + 273.15;
            } 
            else {
                k = temp;
                c = k - 273.15;
                f = (c * 9 / 5) + 32;
            }

            resultArea.setText(
                "Celsius: " + String.format("%.2f", c) + " °C\n" +
                "Fahrenheit: " + String.format("%.2f", f) + " °F\n" +
                "Kelvin: " + String.format("%.2f", k) + " K"
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
