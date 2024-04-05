import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Espresso extends Coffee implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("You have selected Espresso Menu");
    JButton goBack = new JButton("<--");
    JComboBox comboBox = new JComboBox();

    Espresso() {

        label.setBounds(0,0,600,50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        comboBox = new JComboBox(milkOptions);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);

        frame.add(goBack);
        frame.add(label);
        frame.add(comboBox);

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
