import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Latte extends Espresso implements ActionListener {
    JFrame frame = new JFrame();
    JButton goBack = new JButton("<");
    JLabel labelMenu = new JLabel("You have selected the Latte Menu");
    JLabel labelSize = new JLabel("Select the size: ");
    JComboBox comboBox = new JComboBox();
    JLabel labelTemp = new JLabel("Select Hot or Iced: ");
    JComboBox comboBox2 = new JComboBox();
    JLabel labelShots = new JLabel("How many espresso shots? ");
    JComboBox comboBox3 = new JComboBox();
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JComboBox comboBox4 = new JComboBox();
    //JButton cart = new JButton();

    Latte() {

        labelMenu.setBounds(5,0,600,50);
        //label.setFont(new Font(null, Font.PLAIN,20));

        goBack.setBounds(630,10,50,50);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

//        cart.setBounds(590,10,40,40);
//        cart.setFocusable(false);
//        cart.addActionListener(this);

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

        labelMilk.setBounds(50, 255,150,25);
        labelMilk.setFont(new Font(null, Font.BOLD, 15));

        comboBox4 = new JComboBox(milkOptions);
        comboBox4.addActionListener(this);
        comboBox4.setBounds(50,285,150,30);

        labelFlavors.setBounds(300,45,250,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        flavorsCB1 = new JCheckBox("vanilla (+$0.50)");
        flavorsCB1.addActionListener(this);
        flavorsCB1.setBounds(300,75,150,30);

        flavorsCB2 = new JCheckBox("mocha (+$0.50)");
        flavorsCB2.addActionListener(this);
        flavorsCB2.setBounds(300,105,150,30);

        flavorsCB3 = new JCheckBox("caramel (+$0.50)");
        flavorsCB3.addActionListener(this);
        flavorsCB3.setBounds(300,135,150,30);

        flavorsCB4 = new JCheckBox("brown sugar (+$0.75)");
        flavorsCB4.addActionListener(this);
        flavorsCB4.setBounds(300,165,150,30);

        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(300, 285, 150, 30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        frame.add(labelMenu);
        frame.add(goBack);
        frame.add(labelSize);
        frame.add(comboBox);
        frame.add(labelTemp);
        frame.add(comboBox2);
        frame.add(labelShots);
        frame.add(comboBox3);
        frame.add(labelMilk);
        frame.add(comboBox4);
        frame.add(labelFlavors);
        frame.add(flavorsCB1);
        frame.add(flavorsCB2);
        frame.add(flavorsCB3);
        frame.add(flavorsCB4);
        frame.add(background);
        frame.add(prepareDrink);
        //frame.add(cart);

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
//        if (e.getSource() == comboBox) {
//            System.out.println(comboBox.getSelectedItem());
//        }
//        if (e.getSource() == comboBox2) {
//            System.out.println(comboBox2.getSelectedItem());
//        }
//        if (e.getSource() == comboBox3) {
//            System.out.println(comboBox3.getSelectedItem());
//        }
//        if (e.getSource() == comboBox4) {
//            System.out.println(comboBox4.getSelectedItem());
//        }
//        if (e.getSource() == flavorsCB1) {
//            System.out.println(flavorsCB1.getText());
//        }
//        if (e.getSource() == flavorsCB2) {
//            System.out.println(flavorsCB2.getText());
//        }
//        if (e.getSource() == flavorsCB3) {
//            System.out.println(flavorsCB3.getText());
//        }
//        if (e.getSource() == flavorsCB4) {
//            System.out.println(flavorsCB4.getText());
//        }
        if (e.getSource() == prepareDrink) {
            String preparation = prepare();
            JOptionPane.showMessageDialog(null, preparation);
        }
        if (e.getSource() == cart) {
            frame.dispose();
            Checkout checkout = new Checkout();
        }
    }
        public String prepare() {
            String selectedsize = (String) comboBox.getSelectedItem();
            String selectedTemp = (String) comboBox2.getSelectedItem();
            String selectedEShots = (String) comboBox3.getSelectedItem();
            String selectedMilk = (String) comboBox4.getSelectedItem();
            String flavor1 = (String) flavorsCB1.getText();
            String flavor2 = (String) flavorsCB2.getText();
            String flavor3 = (String) flavorsCB3.getText();
            String flavor4 = (String) flavorsCB4.getText();

            String instructions = "Preparing your Coffee Order: \n\n";
            instructions += "Getting your " + selectedsize +" cup" + "\n";
            instructions += " Getting that perfect temperature of " + selectedTemp + "\n";
            instructions += "Adding the perfect amount of " + selectedEShots + " espresso shots" + "\n";
            instructions += "Pouring in your favorite " + selectedMilk + "\n";
            if (flavorsCB1.isSelected()) {
                instructions += "Adding a pump of " + flavor1 + "\n";
            }
            if (flavorsCB2.isSelected()) {
                instructions += "Adding a pump of " + flavor2 + "\n";
            }
            if (flavorsCB3.isSelected()) {
                instructions += "Adding a pump of " + flavor3 + "\n";
            }
            if (flavorsCB4.isSelected()) {
                instructions += "Adding a pump of " + flavor4 + "\n";
            }
            instructions += "Your order is now ready, enjoy!";

            return instructions;
        }
    }
