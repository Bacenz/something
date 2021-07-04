import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class GUI implements ActionListener{

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
    public GUI(){

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
        button.addActionListener(this);

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
        String[] units = {"cm","m","inch","foot"};
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
        finalResult.setBounds(10,200,150,25);

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

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Format the output
        DecimalFormat format = new DecimalFormat("0.00##");

        //Get string from userInput text field and convert to double
        String input = userInput.getText();
        double inputD = 0;
        double res = 0;

        //State system to display input
        int state = 0;

        //Check the input
        if(input.isEmpty()) {
            state = 1;
        } else {
            try {
                inputD = Double.parseDouble(input);
            } catch (NumberFormatException nfe){
                state = 2;
            }
        }

        //Get input from combobox
        int x = box.getSelectedIndex();
        int y = resultBox.getSelectedIndex();

        //Display the result according to state
        if(state == 0) {
            //Display the result
            if (x == y) {
                res = inputD;
                finalResult.setText("Result: " + res);
            } else if (x == 0) { //cm to different unit
                if (y == 1) {
                    res = inputD / 100;
                } else if (y == 2) {
                    res = inputD / 2.54;
                } else {
                    res = inputD / 30.48;
                }
            } else if (x == 1) { //m to different unit
                if (y == 0) {
                    res = inputD * 100;
                } else if (y == 2) {
                    res = inputD * 39.37;
                } else {
                    res = inputD / 3.281;
                }
            } else if (x == 2) {//inch to different unit
                if (y == 0) {
                    res = inputD * 2.54;
                } else if (y == 1) {
                    res = inputD / 39.37;
                } else {
                    res = inputD / 12;
                }
            } else { //foot to different unit
                if (y == 0) {
                    res = inputD * 30.48;
                } else if (y == 1) {
                    res = inputD / 3.281;
                } else {
                    res = inputD * 12;
                }
            }
            finalResult.setText("Results: " + format.format(res) + " " + resultBox.getSelectedItem());
        } else if(state == 1){
            finalResult.setText("Input is empty");
        } else {
            finalResult.setText("Invalid Input");
        }
    }
}
