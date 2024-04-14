import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Cappuccino extends Espresso implements ActionListener {
    JFrame frame = new JFrame();
    JButton goBack = new JButton("<");

    JLabel labelSize = new JLabel("Cappuccino only comes as a 6 oz      $4.00");
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JComboBox comboBox = new JComboBox();
    JLabel labelTemp = new JLabel("Select Hot or Iced: ");
    JComboBox comboBox2 = new JComboBox();
    JLabel labelEType = new JLabel("What kind of espresso? ");
    JComboBox comboBox3 = new JComboBox();
    JLabel labelShots = new JLabel("How many espresso shots? ");
    JComboBox comboBox4 = new JComboBox();
    JButton cart = new JButton();

    Cappuccino() {

        goBack.setBounds(630, 10, 50, 50);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        cart.setBounds(590, 10, 40, 40);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelSize.setBounds(50, 15, 400, 25);
        labelSize.setFont(new Font(null, Font.BOLD, 15));

        labelTemp.setBounds(50, 45, 150, 25);
        labelTemp.setFont(new Font(null, Font.BOLD, 15));

        comboBox2 = new JComboBox(temp);
        comboBox2.addActionListener(this);
        comboBox2.setBounds(50, 75, 150, 30);

        labelMilk.setBounds(50, 115, 150, 25);
        labelMilk.setFont(new Font(null, Font.BOLD, 15));

        comboBox = new JComboBox(milkOptions);
        comboBox.addActionListener(this);
        comboBox.setBounds(50, 145, 150, 30);

        labelEType.setBounds(50, 185, 250, 25);
        labelEType.setFont(new Font(null, Font.BOLD, 15));

        comboBox3 = new JComboBox(espressoType);
        comboBox3.addActionListener(this);
        comboBox3.setBounds(50, 215, 150, 30);

        labelShots.setBounds(50, 255, 250, 30);
        labelShots.setFont(new Font(null, Font.BOLD, 15));

        comboBox4 = new JComboBox<>(eShots);
        comboBox4.addActionListener(this);
        comboBox4.setBounds(50, 285, 150, 30);

        labelFlavors.setBounds(300,45,250,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        flavorsCB1 = new JCheckBox("vanilla (+$0.35)");
        flavorsCB1.addActionListener(this);
        flavorsCB1.setBounds(300,75,150,30);

        flavorsCB2 = new JCheckBox("mocha (+$0.35)");
        flavorsCB2.addActionListener(this);
        flavorsCB2.setBounds(300,105,150,30);

        flavorsCB3 = new JCheckBox("caramel (+$0.35)");
        flavorsCB3.addActionListener(this);
        flavorsCB3.setBounds(300,135,150,30);

        flavorsCB4 = new JCheckBox("brown sugar (+$0.35)");
        flavorsCB4.addActionListener(this);
        flavorsCB4.setBounds(300,165,150,30);

        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(300, 285, 150, 30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);

        background.setBounds(0, 0, 700, 400);
        background.setFocusable(false);
        background.setVisible(true);

        frame.add(goBack);
        frame.add(labelSize);
        frame.add(labelTemp);
        frame.add(comboBox2);
        frame.add(labelEType);
        frame.add(comboBox3);
        frame.add(labelMilk);
        frame.add(comboBox);
        frame.add(labelShots);
        frame.add(comboBox4);
        frame.add(labelFlavors);
        frame.add(flavorsCB1);
        frame.add(flavorsCB2);
        frame.add(flavorsCB3);
        frame.add(flavorsCB4);
        frame.add(prepareDrink);
        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
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
        if (e.getSource() == flavorsCB1) {
            System.out.println(flavorsCB1.getText());
        }
        if (e.getSource() == flavorsCB2) {
            System.out.println(flavorsCB2.getText());
        }
        if (e.getSource() == flavorsCB3) {
            System.out.println(flavorsCB3.getText());
        }
        if (e.getSource() == flavorsCB4) {
            System.out.println(flavorsCB4.getText());
        }
        if (e.getSource() == prepareDrink) {
//            System.out.println(prepareDrink.getSelectedItem());
            frame.dispose();
            Checkout checkout = new Checkout();
        }
        if (e.getSource() == cart) {
            frame.dispose();
            Checkout checkout = new Checkout();
        }
    }
}
