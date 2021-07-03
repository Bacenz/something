import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private static JPanel panel;
    private static JFrame frame;

    private static JLabel titleText;
    private static JLabel label;
    private static JLabel convert;
    private static JLabel convertTo;
    private static JLabel result;
    private static JLabel finalResult;

    private static JTextField userInput;

    private static JComboBox resultBox;
    private static JComboBox box;


    public static void main(String[] args) {

        panel = new JPanel();
        frame = new JFrame("Unit Conversion");

        //Format font
        Font font = new Font("Arial", Font.BOLD,25);

        //Add title text
        titleText = new JLabel("Unit Conversion");
        titleText.setFont(font);
        titleText.setForeground(Color.BLUE);
        titleText.setBounds(10,15,200,25);

        //Add button
        JButton button = new JButton("Convert");
        button.setBounds(110,75,90,25);

        //Prompt user's input
        label = new JLabel("Enter the value");
        label.setBounds(10,50,90,25);

        //User's input field
        userInput = new JTextField();
        userInput.setBounds(10,75,90,25);

        //Prompt user's to select which unit
        convert = new JLabel("Select unit to convert from") ;
        convert.setBounds(10,100,150,25);

        //Selection box
        String[] units = {"cm","inch","foot","m"};
        box = new JComboBox(units);
        box.setSelectedIndex(0);
        box.setBounds(10,125,90,25);

        //Prompt user's to select which unit
        result = new JLabel("Select unit to convert to");
        result.setBounds(10,150,150,25);

        //Selection box
        resultBox = new JComboBox(units);
        resultBox.setSelectedIndex(1);
        resultBox.setBounds(10,175,90,25);

        //Result
        finalResult = new JLabel("Result is: 0");
        finalResult.setBounds(10,200,90,25);

        //Panel setup
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null);
        panel.add(label);
        panel.add(userInput);
        panel.add(convert);
        panel.add(box);
        panel.add(titleText);
        panel.add(result);
        panel.add(resultBox);
        panel.add(finalResult);
        panel.add(button);

        //Frame setup
        frame.setSize(300,300);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}
