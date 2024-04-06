import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Latte extends Espresso implements ActionListener {
    JFrame frame = new JFrame();
    JButton goBack = new JButton("<--");
    JLabel labelSize = new JLabel("Select the size: ");
    JComboBox comboBox = new JComboBox();
    JLabel labelTemp = new JLabel("Select Hot or Iced: ");
    JComboBox comboBox2 = new JComboBox();
    JLabel labelShots = new JLabel("How many espresso shots? ");
    JComboBox comboBox3 = new JComboBox();
    JLabel labelFlavors = new JLabel("Any flavors? ");
    JComboBox comboBox4 = new JComboBox();

    Latte() {

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        labelSize.setBounds(50,45,150,25);
        labelSize.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(size);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);

        labelTemp.setBounds(50,115,150,25);
        labelTemp.setFont(new Font(null, Font.BOLD,15));

        comboBox2 = new JComboBox(temp);
        comboBox2.addActionListener(this);
        comboBox2.setBounds(50,145,150,30);

        labelShots.setBounds(50, 185,250,25);
        labelShots.setFont(new Font(null, Font.BOLD, 15));

        comboBox3 = new JComboBox(eShots);
        comboBox3.addActionListener(this);
        comboBox3.setBounds(50,215,150,30);

        labelFlavors.setBounds(50, 255,150,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        comboBox4 = new JComboBox(flavors);
        comboBox4.addActionListener(this);
        comboBox4.setBounds(50,285,150,30);

        frame.add(goBack);
        frame.add(labelSize);
        frame.add(comboBox);
        frame.add(labelTemp);
        frame.add(comboBox2);
        frame.add(labelShots);
        frame.add(comboBox3);
        frame.add(labelFlavors);
        frame.add(comboBox4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            frame.dispose();
            Espresso espressoMenu = new Espresso();
        }
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
        if (e.getSource() == comboBox2) {
            System.out.println(comboBox2.getSelectedItem());
        }
        if (e.getSource() == comboBox3) {
            System.out.println(comboBox3.getSelectedItem());
        }
        if (e.getSource() == comboBox4) {
            System.out.println(comboBox4.getSelectedItem());
        }
    }
}
