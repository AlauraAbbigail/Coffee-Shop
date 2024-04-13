import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// in order for this to work I put a second in comment that you can put in coffee in order to this csv
public class CustomerGui implements ActionListener {
     Coffee coffeeH;
    private static final String CSV_FILE_PATH = "orderH.csv";
    private JTextArea orderTextArea;
    RegularCustomer regular;

    PremiumCustomer premiumCustomer;
    JFrame frame = new JFrame();
    //background image made by Alaura Buzbee
    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
    Image icon = pic.getImage();
    Image scaledImage = icon.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
    JLabel background = new JLabel(new ImageIcon(scaledImage));
    JLabel title = new JLabel("Customer Info");
    JLabel fName = new JLabel("Name:");
    JLabel address = new JLabel("Address:");
    JLabel phone = new JLabel("Phone:");
    JButton Exit = new JButton("Exit");

    //RadioButton
    JRadioButton premium = new JRadioButton("Are you a Premium customer?");



    //TEXTFIELD
    JTextField fName1 = new JTextField();
    JTextField resident = new JTextField();
    JTextField phone1 = new JTextField();



    //JBUTTON
    JButton viewOrder = new JButton("View order");
    JButton cancelButton = new JButton("Cancel");

    CustomerGui(){
        coffeeH = new Coffee(CSV_FILE_PATH);
        title.setBounds(100,0,500,50);
        title.setFont(new Font(null,Font.BOLD,25));

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        premium.setBounds(450,300,300,50);
        premium.addActionListener(this);

        fName.setBounds(50,90,100,20);
        fName.setFont(new Font(null,Font.BOLD,16));
        fName1.setBounds(150,90,300,20);

        address.setBounds(50,120,100,20);
        address.setFont(new Font(null,Font.BOLD,16));
        resident.setBounds(150,120,300,20);

        phone.setBounds(50,150,100,20);
        phone.setFont(new Font(null,Font.BOLD,16));
        phone1.setBounds(150,150,300,20);



        // REG BUTTON
        viewOrder.setBounds(50,320,100,40);
        viewOrder.setFocusable(false);
        viewOrder.addActionListener(this);
        viewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderDetail= fName1.getText()+" "+ phone1.getText()+" "+ resident.getText();
                coffeeH.saveOrder(orderDetail);
                if(e.getSource()==viewOrder){
                    JOptionPane.showMessageDialog(null, "order placed successfull!");
                }
            }
        });

        // CANCEL BUTTON
        cancelButton.setBounds(300,320,100,40);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        Exit.setBounds(250,320,100,40);
        Exit.setFocusable(false);
        Exit.addActionListener(this);

        // to add label to frame
        frame.add(title);
        frame.add(fName);
        frame.add(address);
        frame.add(resident);
        frame.add(phone);
        frame.add(viewOrder);
        frame.add(premium);

        //JTEXTFIELD
        frame.add(fName1);
        frame.add(resident);
        frame.add(phone1);

        // JBUTTON
        frame.add(Exit);
        frame.add(cancelButton);
        frame.add(background);

        orderTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane();
        updateOrderTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String name = fName1.getText();
        String phone = phone1.getText();
        String address = resident.getText();
        if(e.getSource()==premium){
            System.out.println("Your order:"+name+" "+phone+" "+address+ "10 PERCENT DISCOUNT");
        }
        if(e.getSource()==Exit){
            frame.dispose();
            Coffee coffee = new Coffee();
        }
    }
    private void updateOrderTextArea() {
        List<String> orders = coffeeH.loadOrders();
        orderTextArea.setText(String.join("\n", orders));
    }
}
----------------------------------------------------------------------------------------
    COFFEE CLASS
import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Coffee implements ActionListener {
//    private String filePath;
//
//    JFrame frame = new JFrame();
//    JButton option1 = new JButton("Espresso");
//    JButton option2 = new JButton("Filtered Coffee");
//    JComboBox comboBox = new JComboBox();
//    String[] milkOptions = {"whole milk", "almond milk", "oatmilk"};
//    String[] flavors = {"vanilla", "mocha", "caramel", "brown sugar"};
//    String[] size = {"12 oz", "16 oz"};
//    String[] temp = {"Hot", "Iced"};
//    JButton addCart = new JButton("Add to Cart?");
//    JButton cart = new JButton();
//    JButton finalCheckout = new JButton("Ready to check out?");
//    JButton addMore = new JButton("Want to order more?");
//
//    //menu title (used a generator to create)
//    ImageIcon menuPic = new ImageIcon(getClass().getResource("8-Bit_Coffee.png"));
//    Image menuIcon = menuPic.getImage();
//    Image scaledMenuImage = menuIcon.getScaledInstance(650,45, Image.SCALE_SMOOTH);
//    JLabel menuTitle = new JLabel(new ImageIcon(scaledMenuImage));
//
//    //background image made by Alaura Buzbee
//    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
//    Image icon = pic.getImage();
//    Image scaledImage = icon.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
//    JLabel background = new JLabel(new ImageIcon(scaledImage));
//
//    //espresso image made by Alaura Buzbee
//    ImageIcon pic2 = new ImageIcon(getClass().getResource("Cappuccino.png"));
//    Image icon2 = pic2.getImage();
//    Image scaledImage2 = icon2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
//    JLabel espressoImage = new JLabel(new ImageIcon(scaledImage2));
//
//    //filter coffee image made by Alaura Buzbee
//    ImageIcon pic3 = new ImageIcon(getClass().getResource("Filter_Coffee.png"));
//    Image icon3 = pic3.getImage();
//    Image scaledImage3 = icon3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
//    JLabel filterImage = new JLabel(new ImageIcon(scaledImage3));
//
//    Coffee() {
//
//        option1.setBounds(150, 260, 150, 40);
//        option1.setFocusable(false);
//        option1.addActionListener(this);
//
//        option2.setBounds(400, 260, 150, 40);
//        option2.setFocusable(false);
//        option2.addActionListener(this);
//
//        option1.setBackground(new Color(142, 111, 80));
//        option2.setBackground(new Color(88,58,41));
//
//        comboBox = new JComboBox();
//        comboBox.addActionListener(this);
//
//        background.setBounds(0,0,700,400);
//        background.setFocusable(false);
//        background.setVisible(true);
//
//        espressoImage.setBounds(150,100,150,150);
//        espressoImage.setFocusable(false);
//        espressoImage.setVisible(true);
//
//        filterImage.setBounds(400,100,150,150);
//        filterImage.setFocusable(false);
//        filterImage.setVisible(true);
//
//        menuTitle.setBounds(15,5,650,60);
//        menuTitle.setFocusable(false);
//        menuTitle.setVisible(true);
//
//        frame.add(option1);
//        frame.add(option2);
//        frame.add(espressoImage);
//        frame.add(filterImage);
//        frame.add(menuTitle);
//        frame.add(background);
//
////        getContentPane.setBackground(Color.RED);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(700,400);
//        frame.setLayout(null);
//        frame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==option1) {
//            frame.dispose();
//            Espresso espressoMenu = new Espresso();
//        }
//        if(e.getSource()==option2) {
//            frame.dispose();
//            FilteredCoffee fCMenu = new FilteredCoffee();
//        }
//    }
//    public Coffee(String filePath){
//        this.filePath = filePath;
//    }
//    public void saveOrder(String orderDetails){
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
//            writer.write(orderDetails);
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public java.util.List<String> loadOrders(){
//        List<String> orders = new ArrayList<>();
//        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//            String line;
//            while((line = reader.readLine())!= null){
//                orders.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return orders;
//    }
//}
