import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilteredCoffee extends Coffee implements ActionListener {
    JFrame frame = new JFrame();
    //placeholder JLabel label = new JLabel("You have selected the Filtered Coffee Menu");
    JButton goBack = new JButton("<");
    JLabel labelSize = new JLabel("Select the size: ");
    JComboBox comboBoxSize = new JComboBox();
    JComboBox comboBox = new JComboBox();
    JLabel label2 = new JLabel("Select Brew Type:");
    String[] brewType = {"Light", "Medium", "Dark"};
    JLabel label3 = new JLabel("Optional: Creamer");
    String[] splashMilk = {"Splash of Half+Half", "Splash of Whole Milk", "Splash of Oatmilk +($.030)", "Splash of Almond Milk +($0.30)"};
    JComboBox comboBoxCreamer = new JComboBox();
    JButton cart = new JButton();

    //filtered coffee menu banner
    ImageIcon picFC = new ImageIcon(getClass().getResource("filteredCoffeeImage.png"));
    Image iconFC = picFC.getImage();
    Image scaledImageFC = iconFC.getScaledInstance(500,25, Image.SCALE_SMOOTH);
    JLabel bannerFC = new JLabel(new ImageIcon(scaledImageFC));


    FilteredCoffee() {

        bannerFC.setBounds(5,5,600,30);
        bannerFC.setFocusable(false);
        bannerFC.setVisible(true);

        goBack.setBounds(630,10,50,50);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        cart.setBounds(590,10,40,40);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelSize.setBounds(50,45,200,25);
        labelSize.setFont(new Font(null, Font.PLAIN, 15));

        comboBoxSize = new JComboBox(size);
        comboBoxSize.addActionListener(this);
        comboBoxSize.setBounds(50,75,150,30);

        label2.setBounds(50,115,150,25);
        label2.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(brewType);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,145,150,30);

        label3.setBounds(50,185,150,25);
        label3.setFont(new Font(null, Font.BOLD,15));

        comboBoxCreamer = new JComboBox(splashMilk);
        comboBoxCreamer.addActionListener(this);
        comboBoxCreamer.setBounds(50,215,200,30);

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

        frame.add(goBack);
        frame.add(bannerFC);
        frame.add(labelSize);
        frame.add(comboBoxSize);
        frame.add(comboBox);
        frame.add(label2);
        frame.add(label3);
        frame.add(comboBoxCreamer);
        frame.add(labelFlavors);
        frame.add(flavorsCB1);
        frame.add(flavorsCB2);
        frame.add(flavorsCB3);
        frame.add(flavorsCB4);
        frame.add(prepareDrink);
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
    }
}
