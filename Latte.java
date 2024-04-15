
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

public class Latte extends Espresso implements ActionListener {
    Coffee coffee;
    private JTextArea orderTextArea;
    private double ltotal;
    private double laSub;
    private final Double LATTE = 5.00;

    private static final String CSV_FILE_PATH = "orderH.csv";
    double total;
    double subtotal= 0;

    private Checkout checkout;
    private PremiumCustomer premiumCustomer;

    JFrame frame = new JFrame();
    JButton goBack = new JButton("<");
    JLabel labelMenu = new JLabel("You have selected the Latte Menu");
    JLabel labelSize = new JLabel("Select the size: ");
    JCheckBox vanila= new JCheckBox("Vanila $0.35");
    JCheckBox mocha = new JCheckBox("Mocha  $0.35");
    JCheckBox caramel = new JCheckBox("Caramel  $0.35");
    JCheckBox brownSugar = new JCheckBox("Brown Sugar   $0.35");
    JComboBox comboBox = new JComboBox();
    JLabel labelTemp = new JLabel("Select Hot or Iced: ");
    JComboBox comboBox2 = new JComboBox();
    JLabel labelShots = new JLabel("How many espresso shots? ");
    JComboBox comboBox3 = new JComboBox();
    JLabel labelFlavors = new JLabel("Any flavors? ");
    JComboBox comboBox4 = new JComboBox();
    JButton addCart = new JButton("cart?");
    JButton cart = new JButton("Checkout");
    JLabel totlab = new JLabel("Total");

    JTextField Totalbox = new JTextField();
    JTextField SubBox = new JTextField();
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JTextArea order = new JTextArea("Your order");

    Latte() {
        coffee= new Coffee(CSV_FILE_PATH);

        labelMenu.setBounds(5,0,600,50);
        label.setFont(new Font(null, Font.PLAIN,20));

        order.setBounds(500,200,300,300);
        order.setFocusable(false);


        goBack.setBounds(640,10,60,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        cart.setBounds(300,320,100,40);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelSize.setBounds(50,45,150,25);
        labelSize.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(size);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);
        //LADARIUS PATRICK
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== comboBox){
                    String orderDetail = (String)comboBox.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox.getSelectedItem());
                }
            }
        });
        labelTemp.setBounds(50,115,150,25);
        labelTemp.setFont(new Font(null, Font.BOLD,15));

        comboBox2 = new JComboBox(temp);
        comboBox2.addActionListener(this);
        comboBox2.setBounds(50,145,150,30);
        //LADARIUS PATRICK
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== comboBox2){
                    String orderDetail= (String)comboBox2.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox2.getSelectedItem());
                }
            }
        });

        labelShots.setBounds(50, 185,250,25);
        labelShots.setFont(new Font(null, Font.BOLD, 15));

        vanila = new JCheckBox("vanilla (+$0.50)");
        vanila.addActionListener(this);
        vanila.setBounds(300,75,150,30);
        //LADARIUS PATRICK
        vanila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vanila.isSelected()) {
                    subtotal = subtotal + 0.50;
                } else {
                    subtotal = subtotal - 0.50;
                    System.out.println(vanila.getText() + " removed");
                }
            }

        });
        mocha = new JCheckBox("mocha (+$0.50)");
        mocha.addActionListener(this);
        mocha.setBounds(300,105,150,30);
        //LADARIUS PATRICK
        mocha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mocha.isSelected()) {
                    subtotal = subtotal + 0.50;
                }else {
                    subtotal = subtotal - 0.50;
                    System.out.println(mocha.getText() + " removed");
                }
            }
        });
        caramel = new JCheckBox("caramel (+$0.50)");
        caramel.addActionListener(this);
        caramel.setBounds(300,135,150,30);
        //LADARIUS PATRICK
        caramel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caramel.isSelected()) {
                    subtotal = subtotal + 0.50;
                }else {
                    subtotal = subtotal - 0.50;
                    System.out.println(caramel.getText() + " removed");
                }
            }
        });

        brownSugar = new JCheckBox("brown sugar (+$0.75)");
        brownSugar.addActionListener(this);
        brownSugar.setBounds(300,165,150,30);
        //LADARIUS PATRICK
        brownSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (brownSugar.isSelected()) {
                    subtotal = subtotal + 0.75;
                }else {
                    subtotal = subtotal - 0.75;
                    System.out.println(brownSugar.getText() + " removed");
                }
            }
        });
        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(300, 285, 150, 30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);

        totlab.setBounds(500,280,100,20);
        totlab.setFont(new Font(null,Font.BOLD,14));
        Totalbox.setBounds(500,300,100,20);
        SubBox.setBounds(500,250,100,20);


        comboBox3 = new JComboBox(eShots);
        comboBox3.addActionListener(this);
        comboBox3.setBounds(50,215,150,30);
        //LADARIUS PATRICK
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== comboBox3){
                    String orderDetail = (String)comboBox3.getSelectedItem() + " Shot";
                    System.out.println(comboBox3.getSelectedItem()+ " Shot");
                }
            }
        });
        labelFlavors.setBounds(50, 255,150,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        comboBox4 = new JComboBox(flavors);
        comboBox4.addActionListener(this);
        comboBox4.setBounds(50,285,150,30);
        //LADARIUS PATRICK
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==comboBox4){
                    String orderDetail = (String)comboBox4.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox4.getSelectedItem());
                }
            }
        });
        addCart = new JButton("Add to cart?");
        addCart.setBounds(300, 285, 150, 30);
        addCart.setFocusable(false);
        addCart.addActionListener(this);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);


        frame.add(cart);
        frame.add(labelMenu);
        frame.add(goBack);
        frame.add(labelSize);
        frame.add(comboBox);
        frame.add(labelTemp);
        frame.add(comboBox2);
        frame.add(labelShots);
        frame.add(comboBox3);
        frame.add(labelFlavors);
        frame.add(comboBox4);
        frame.add(vanila);
        frame.add(mocha);
        frame.add(caramel);
        frame.add(brownSugar);
        frame.add(prepareDrink);
        frame.add(Totalbox);
        frame.add(totlab);
        frame.add(cart);
        frame.add(background);



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
        if (e.getSource() == cart){
            frame.dispose();
            Checkout out = new Checkout();
        }
        if (e.getSource() == prepareDrink) {
            String preparation = prepare();
            JOptionPane.showMessageDialog(null, preparation);;
        }
        //LADARIUS PATRICK
        DecimalFormat df = new DecimalFormat("0.00");

        SubBox.setText(Double.toString(subtotal));
        subtotal = Double.parseDouble(SubBox.getText());
        total = LATTE + subtotal;
        SubBox.setText(Double.toString(subtotal));
        Totalbox.setText(df.format(subtotal));
        Totalbox.setText(Double.toString(total));
    }



    private void updateOrderTextArea() {
        List<String> orders = coffee.loadOrders();
        orderTextArea.setText(String.join("\n", orders));
    }
    public String prepare() {
        String selectedsize = (String) comboBox.getSelectedItem();
        String selectedTemp = (String) comboBox2.getSelectedItem();
        String selectedEShots = (String) comboBox3.getSelectedItem();
        String selectedMilk = (String) comboBox4.getSelectedItem();
        String flavor1 = (String) vanila.getText();
        String flavor2 = (String) mocha.getText();
        String flavor3 = (String) caramel.getText();
        String flavor4 = (String) brownSugar.getText();

        String instructions = "Preparing your Coffee Order: \n\n";
        instructions += "Getting your " + selectedsize +" cup" + "\n";
        instructions += " Getting that perfect temperature of " + selectedTemp + "\n";
        instructions += "Adding the perfect amount of " + selectedEShots + " espresso shots" + "\n";
        instructions += "Pouring in your favorite " + selectedMilk + "\n";
        if (vanila.isSelected()) {
            instructions += "Adding a pump of " + flavor1 + "\n";
        }
        if (mocha.isSelected()) {
            instructions += "Adding a pump of " + flavor2 + "\n";
        }
        if (caramel.isSelected()) {
            instructions += "Adding a pump of " + flavor3 + "\n";
        }
        if (brownSugar.isSelected()) {
            instructions += "Adding a pump of " + flavor4 + "\n";
        }
        instructions += "Your order is now ready, enjoy!";

        return instructions;
    }
}
