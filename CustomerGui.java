import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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

    JButton menu = new JButton("Start");

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
        menu.setBounds(50,320,100,40);
        menu.setFocusable(false);
        menu.addActionListener(this);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderDetail="Order for: "+ fName1.getText()+" "+ phone1.getText()+" "+ resident.getText();
                coffeeH.saveOrder(orderDetail);
                if(e.getSource()==menu){
                    JOptionPane.showMessageDialog(null, "Welcome to the CoffeeShop "+fName1.getText()+ "!");
                    frame.dispose();
                    Coffee coffee = new Coffee();
                }
            }
        });

        Exit.setBounds(320,320,100,40);
        Exit.setFocusable(false);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(frame,"You want to exit the CoffeeShop?","Confirm Exit",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        // to add label to frame
        frame.add(title);
        frame.add(fName);
        frame.add(address);
        frame.add(resident);
        frame.add(phone);
        frame.add(menu);
        frame.add(premium);

        //JTEXTFIELD
        frame.add(fName1);
        frame.add(resident);
        frame.add(phone1);

        // JBUTTON
        frame.add(Exit);
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
            System.out.println("Customer name: "+name+" phone number: "+phone+" resident: "+address+ " gets 10 PERCENT DISCOUNT");
        }
    }
    private void updateOrderTextArea() {
        List<String> orders = coffeeH.loadOrders();
        orderTextArea.setText(String.join("\n", orders));
    }
}

