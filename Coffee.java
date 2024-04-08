import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coffee implements ActionListener {

    JFrame frame = new JFrame();
    JButton option1 = new JButton("Espresso");
    JButton option2 = new JButton("Filtered Coffee");
    JComboBox comboBox = new JComboBox();
    String[] milkOptions = {"whole milk", "almond milk", "oatmilk"};
    String[] flavors = {"vanilla", "mocha", "caramel", "brown sugar"};
    String[] size = {"6 oz","8 oz","12 oz", "16 oz"};
    String[] temp = {"Hot", "Iced"};
    JButton addCart = new JButton("Add to Cart?");
    JButton cart = new JButton();
    JButton finalCheckout = new JButton("Ready to check out?");
    JButton addMore = new JButton("Want to order more?");

    //background image made by Alaura Buzbee
    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
    Image icon = pic.getImage();
    Image scaledImage = icon.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
    JLabel background = new JLabel(new ImageIcon(scaledImage));

    //espresso image made by Alaura Buzbee
    ImageIcon pic2 = new ImageIcon(getClass().getResource("Cappuccino.png"));
    Image icon2 = pic2.getImage();
    Image scaledImage2 = icon2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    JLabel espressoImage = new JLabel(new ImageIcon(scaledImage2));

    //filter coffee image made by Alaura Buzbee
    ImageIcon pic3 = new ImageIcon(getClass().getResource("Filter_Coffee.png"));
    Image icon3 = pic3.getImage();
    Image scaledImage3 = icon3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    JLabel filterImage = new JLabel(new ImageIcon(scaledImage3));

    Coffee() {

        option1.setBounds(150, 260, 150, 40);
        option1.setFocusable(false);
        option1.addActionListener(this);

        option2.setBounds(400, 260, 150, 40);
        option2.setFocusable(false);
        option2.addActionListener(this);

        option1.setBackground(new Color(142, 111, 80));
        option2.setBackground(new Color(88,58,41));

        comboBox = new JComboBox();
        comboBox.addActionListener(this);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        espressoImage.setBounds(150,100,150,150);
        espressoImage.setFocusable(false);
        espressoImage.setVisible(true);

        filterImage.setBounds(400,100,150,150);
        filterImage.setFocusable(false);
        filterImage.setVisible(true);

        frame.add(option1);
        frame.add(option2);
        frame.add(espressoImage);
        frame.add(filterImage);
        frame.add(background);

//        getContentPane.setBackground(Color.RED);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==option1) {
            frame.dispose();
            Espresso espressoMenu = new Espresso();
        }
        if(e.getSource()==option2) {
            frame.dispose();
            FilteredCoffee fCMenu = new FilteredCoffee();
        }

    }
}
