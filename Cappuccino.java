rt javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;

public class Cappuccino extends Espresso implements ActionListener {
    Coffee coffee;
    private JTextArea orderTextArea;

    private static final String CSV_FILE_PATH = "orderH.csv";
    private double total;
    private double subtotal= 0.0;
    private final double cappuccino = 4.00;
    private String wMilk;
    private String aMilk;
    private String oMilk;

    JFrame frame = new JFrame();
    JButton goBack = new JButton("<");
    JLabel labelSize = new JLabel("Cappuccino only comes as a 6 oz  $4.00");
    JCheckBox vanila= new JCheckBox("Vanila $0.35");
    JCheckBox mocha = new JCheckBox("Mocha  $0.35");
    JCheckBox caramel = new JCheckBox("Caramel  $0.35");
    JCheckBox brownSugar = new JCheckBox("Brown Sugar   $0.35");
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JComboBox comboBox = new JComboBox<>();
    JComboBox comboBox2 = new JComboBox<>();
    JLabel labelTemp = new JLabel("Select Hot or Iced:");
    JComboBox comboBox3 = new JComboBox<>();
    JComboBox comboBox4 = new JComboBox<>();
    JLabel labelShots = new JLabel("How many Shot?");

    JLabel labelEType = new JLabel("What kind of espresso?");
    JButton addCart = new JButton("Add to cart?");

    JButton cart = new JButton("CheckOut");
    JLabel totalLab = new JLabel("Total");
    JLabel subLab = new JLabel("Subtotal");

    JTextField CapTotal = new JTextField();
    JTextField CapSub = new JTextField();

    Cappuccino() {
        coffee= new Coffee(CSV_FILE_PATH);

        goBack.setBounds(540,10,100,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        labelSize.setBounds(50, 15, 400, 25);
        labelSize.setFont(new Font(null, Font.BOLD, 15));

        labelTemp.setBounds(50, 45, 150, 25);
        labelTemp.setFont(new Font(null, Font.BOLD, 15));

        comboBox2 = new JComboBox(temp);
        comboBox2.addActionListener(this);
        comboBox2.setBounds(50, 75, 150, 30);
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==comboBox2){
                    String orderDetail = (String)comboBox2.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox2.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");
                }
            }
        });

        labelEType.setBounds(50, 160, 250, 25);
        labelEType.setFont(new Font(null, Font.BOLD, 15));

        comboBox3 = new JComboBox(espressoType);
        comboBox3.addActionListener(this);
        comboBox3.setBounds(50, 180, 150, 30);
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== comboBox3){
                    String orderDetail = (String)comboBox3.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox3.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");
                }
            }
        });

        labelShots.setBounds(50, 205, 250, 30);
        labelShots.setFont(new Font(null, Font.BOLD, 15));

        comboBox4 = new JComboBox<>(eShots);
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBox4) {
                    String orderDetails = (String)comboBox4.getSelectedItem();
                    coffee.saveOrder(orderDetails +" shots");
                    System.out.println(comboBox4.getSelectedItem()+" shots");
                    JOptionPane.showMessageDialog(null, "order placed!");
                }
            }
        });
        comboBox4.setBounds(50, 245, 150, 30);

        labelFlavors.setBounds(300,45,250,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        cart.setBounds(590,300,100,40);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelMilk.setBounds(50,100,150,25);
        labelMilk.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox<>(milkOptions);
        wMilk = (String) comboBox.getItemAt(0);
        aMilk = (String)comboBox.getItemAt(1);
        oMilk = (String)comboBox.getItemAt(2);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == comboBox){
                    String orderDetail = (String)comboBox.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");
                }
            }
        });

        labelSize.setBounds(50,15,400,25);
        labelSize.setFont(new Font(null,Font.BOLD,15));


        comboBox.setBounds(50,125,150,30);
        totalLab.setBounds(50,330,100,20);
        totalLab.setFont(new Font(null,Font.BOLD,12));
        CapSub.setBounds(50,300,100,20);

        subLab.setBounds(50,280,100,20);
        subLab.setFont(new Font(null,Font.BOLD,12));
        CapTotal.setBounds(50,350,100,20);

        vanila.setBounds(250,75,200,30);
        vanila.addActionListener(this);
        vanila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vanila.isSelected()) {
                    subtotal = subtotal + 0.35;
                }else{
                    subtotal= subtotal -0.35;
                    System.out.println(vanila.getText()+ " removed");
                }
            }
        });

        mocha.setBounds(250,95,200,30);
        mocha.addActionListener(this);
        mocha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mocha.isSelected()) {
                    subtotal = subtotal + 0.35;
                }else{
                    subtotal= subtotal -0.35;
                    System.out.println(mocha.getText()+ " removed");

                }
            }
        });

        caramel.setBounds(250,115,200,30);
        caramel.addActionListener(this);
        caramel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caramel.isSelected()) {
                    subtotal = subtotal + 0.35;
                }else{
                    subtotal= subtotal -0.35;
                    System.out.println(caramel.getText()+ " removed");
                }
            }
        });

        brownSugar.setBounds(250,135,200,30);
        brownSugar.addActionListener(this);
        brownSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (brownSugar.isSelected()) {
                    subtotal = subtotal + 0.35;
                }else{
                    subtotal= subtotal -0.35;
                    System.out.println(brownSugar.getText()+ " removed");
                }
            }
        });


        addCart = new JButton("Checkout");
        addCart.setBounds(500, 348, 150, 30);
        addCart.setFocusable(false);
        addCart.addActionListener(this);

        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(400,285,150,30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);
        frame.add(cart);
        frame.add(vanila);
        frame.add(goBack);
        frame.add(labelMilk);
        frame.add(comboBox);
        frame.add(mocha);
        frame.add(caramel);
        frame.add(brownSugar);
        frame.add(CapTotal);
        frame.add(CapSub);
        frame.add(prepareDrink);
        frame.add(labelSize);
        frame.add(labelTemp);
        frame.add(comboBox2);
        frame.add(labelEType);
        frame.add(comboBox3);
        frame.add(comboBox4);
        frame.add(labelShots);
        frame.add(totalLab);
        frame.add(subLab);
        frame.add(background);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("0.00");

        CapSub.setText(Double.toString(subtotal));
        subtotal = Double.parseDouble(CapSub.getText());
        total = cappuccino + subtotal;
        CapSub.setText(Double.toString(subtotal));
        CapSub.setText(df.format(subtotal));
        CapTotal.setText(Double.toString(total));
        CapTotal.setText(df.format(total));

        if (e.getSource() == goBack) {
            frame.dispose();
            Espresso espressoMenu = new Espresso();
        }

        if(e.getSource()== prepareDrink){
            String preparation = prepare();
            JOptionPane.showMessageDialog(null, preparation);
        }
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());

        }
        if (e.getSource()== cart){
            frame.dispose();
            Checkout out = new Checkout();
        }
        if (e.getSource() == vanila){
            vanila.setText(vanila.getText());
        }
        if (e.getSource()==mocha){
            System.out.println(mocha.getText());
        }
        if(e.getSource()==caramel){
            System.out.println(caramel.getText());
        }
        if(e.getSource()==brownSugar) {
            System.out.println(brownSugar.getText());

        }

    }
    //LADARIUS PATRICK
    private void updateOrderTextArea() {
        List<String> orders = coffee.loadOrders();
        orderTextArea.setText(String.join("\n", orders));
    }
    //Alaura Buzbee
    public String prepare() {
        String selectedEType = (String) comboBox3.getSelectedItem();
        String selectedTemp = (String) comboBox2.getSelectedItem();
        String selectedEShots = (String) comboBox4.getSelectedItem();
        String selectedMilk = (String) comboBox.getSelectedItem();
        String flavor1 = (String) vanila.getText();
        String flavor2 = (String) mocha.getText();
        String flavor3 = (String) caramel.getText();
        String flavor4 = (String) brownSugar.getText();

        String instructions = "Preparing your Coffee Order: \n\n";
        instructions += "Getting your 6 oz cup" + "\n";
        instructions += "Getting that perfect temperature of " + selectedTemp + "\n";
        instructions += "Grinding and pulling your " + selectedEType + " espresso" + "\n";
        instructions += "Adding the perfect amount of " + selectedEShots + " espresso shots" + "\n";
        instructions += "Pouring in your favorite " + selectedMilk + "\n";
        if (vanila.isSelected()) {
            instructions += "Adding a pump of " + flavor1 + "\n";
        }
        if (mocha.isSelected()) {
            instructions += "Adding a pump of " + flavor2 + "\n";
        }
        if (brownSugar.isSelected()) {
            instructions += "Adding a pump of " + flavor3 + "\n";
        }
        if (caramel.isSelected()) {
            instructions += "Adding a pump of " + flavor4 + "\n";
        }
        instructions += "Enjoy your drink, and thanks for coming to 8-Bit Coffee!";

        return instructions;
    }
}




   
