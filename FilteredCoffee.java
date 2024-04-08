import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilteredCoffee extends Coffee implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("You have selected the Filtered Coffee Menu");
    JButton goBack = new JButton("<");
    JComboBox comboBox = new JComboBox();
    JLabel label2 = new JLabel("Select Brew Type:");
    String[] brewType = {"Light", "Medium", "Dark"};


    FilteredCoffee() {

        label.setBounds(0,0,600,50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        label2.setBounds(50,45,150,25);
        label2.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(brewType);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        frame.add(goBack);
        frame.add(label);
        frame.add(comboBox);
        frame.add(label2);
        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==goBack) {
            frame.dispose();
            Coffee coffee = new Coffee();
        }
        if(e.getSource()==comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
