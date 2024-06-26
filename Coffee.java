import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Coffee implements ActionListener {
    private String filePath;
    JFrame frame = new JFrame();
    JButton option1 = new JButton("Espresso");
    JButton option2 = new JButton("Filtered Coffee");
    JComboBox comboBox = new JComboBox();

    String[] milkOptions = {"whole milk ", "almond milk", "oatmilk"};

    String[] espressoType = {"Regular","Decaf","Half Caff"};
    String[] flavors = {"vanilla", "mocha", "caramel", "brown sugar"};

    String[] size = {"12 oz", "16 oz"};
    String[] temp = {"Hot", "Iced"};
    JLabel labelFlavors = new JLabel("Optional: Select Flavors");
    JCheckBox flavorCB1 = new JCheckBox();
    JCheckBox flavorCB2 = new JCheckBox();
    JCheckBox flavorCB3 = new JCheckBox();
    JCheckBox flavorCB4 = new JCheckBox();
    JButton prepareDrink = new JButton("Prepare Order");

    JButton cart = new JButton();
    JButton finalCheckout = new JButton("Ready to check out?");
    JButton addMore = new JButton("Want to order more?");

    //menu title (used a generator to create)
    ImageIcon menuPic = new ImageIcon(getClass().getResource("8-Bit_Coffee.png"));
    Image menuIcon = menuPic.getImage();
    Image scaledMenuImage = menuIcon.getScaledInstance(650,45, Image.SCALE_SMOOTH);
    JLabel menuTitle = new JLabel(new ImageIcon(scaledMenuImage));

    //background image made by Alaura Buzbee
    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
    Image icon = pic.getImage();
    Image scaledImage = icon.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
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

        menuTitle.setBounds(15,5,650,60);
        menuTitle.setFocusable(false);
        menuTitle.setVisible(true);

        frame.add(option1);
        frame.add(option2);
        frame.add(espressoImage);
        frame.add(filterImage);
        frame.add(menuTitle);
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
        if(e.getSource()==prepareDrink) {
            String preparation = prepare();
            JOptionPane.showMessageDialog(null, preparation);
        }
    }
    public Coffee(String filePath){
        this.filePath = filePath;
    }
    public void saveOrder(String orderDetails){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            writer.write(orderDetails);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public java.util.List<String> loadOrders(){
        List<String> orders = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine())!= null){
                orders.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
