import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FilteredCoffee extends Coffee implements ActionListener {

    Coffee coffee;

    private static final String CSV_FILE_PATH = "orderH.csv";
    private JTextArea orderTextArea;
    private double ftotal;
    private double subTotal= 0.0;
    private final double FILTERCOFFEE = 4.00;
    JFrame frame = new JFrame();
    JLabel labelSize = new JLabel("Select the size: ");
    JLabel label = new JLabel("You have selected the Filtered Coffee Menu");
    JButton goBack = new JButton("<");
    JComboBox comboBox = new JComboBox();
    JComboBox comboBoxSize = new JComboBox();
    JLabel label2 = new JLabel("Select Brew Type:");
    String[] brewType = {"Light     $1.00", "Medium     $2.00", "Dark   $3.00"};
    JButton addCart = new JButton("Add to cart?");
    JButton cart = new JButton("Cart");
    JLabel label3 = new JLabel("Optional: Creamer");
    String[] splashMilk = {"Splash of Half+Half", "Splash of Whole Milk", "Splash of Oatmilk +($.030)", "Splash of Almond Milk +($0.30)"};
    JComboBox comboBoxCreamer = new JComboBox<>();
    JCheckBox vanila= new JCheckBox("Vanila $0.35");
    JCheckBox mocha = new JCheckBox("Mocha  $0.35");
    JCheckBox caramel = new JCheckBox("Caramel  $0.35");
    JCheckBox brownSugar = new JCheckBox("Brown Sugar   $0.35");
    JLabel total = new JLabel("Total");
    JTextField subtotal = new JTextField();
    JTextField Total = new JTextField();
    JButton payorder = new JButton("Pay Order");


    FilteredCoffee() {
        coffee = new Coffee(CSV_FILE_PATH);

        label.setBounds(0,0,600,50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        total.setBounds(500,250,100,20);
        total.setFont(new Font(null,Font.BOLD,14));
        Total.setBounds(500,270,100,20);

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        cart.setBounds(590,10,110,60);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelSize.setBounds(50,45,200,25);
        labelSize.setFont(new Font(null, Font.PLAIN, 15));

        comboBoxSize = new JComboBox(size);
        comboBoxSize.addActionListener(this);
        comboBoxSize.setBounds(50,75,150,30);
        comboBoxSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBoxSize) {
                    // add to total for this one
                    String orderDetail = (String) comboBoxSize.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBoxSize.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");
                }
            }
        });
        label2.setBounds(50,45,150,25);
        label2.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(brewType);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== comboBox) {
                    // add to total for this one
                    String orderDetail = (String) comboBox.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBox.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");

                }
            }
        });
        label3.setBounds(50,185,150,25);
        label3.setFont(new Font(null, Font.BOLD,15));

        comboBoxCreamer = new JComboBox(splashMilk);
        comboBoxCreamer.addActionListener(this);
        comboBoxCreamer.setBounds(50,215,200,30);
        comboBoxCreamer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== comboBoxCreamer) {
                    // add to total for this one
                    String orderDetail = (String) comboBoxCreamer.getSelectedItem();
                    coffee.saveOrder(orderDetail);
                    System.out.println(comboBoxCreamer.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "order placed!");
                }

            }
        });
        labelFlavors.setBounds(300,45,250,25);
        labelFlavors.setFont(new Font(null, Font.BOLD, 15));

        vanila = new JCheckBox("vanilla (+$0.50)");
        vanila.addActionListener(this);
        vanila.setBounds(300,75,150,30);
        vanila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vanila.isSelected()) {
                    subTotal = subTotal + 0.50;
                }else {
                    subTotal = subTotal - 0.50;
                    System.out.println(vanila.getText() + " removed");
                }
            }
        });

        mocha = new JCheckBox("mocha (+$0.50)");
        mocha.addActionListener(this);
        mocha.setBounds(300,105,150,30);
        mocha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mocha.isSelected()) {
                    subTotal = subTotal + 0.50;
                }else {
                    subTotal = subTotal - 0.50;
                    System.out.println(mocha.getText() + " removed");
                }
            }
        });

        caramel = new JCheckBox("caramel (+$0.50)");
        caramel.addActionListener(this);
        caramel.setBounds(300,135,150,30);
        caramel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (caramel.isSelected()) {
                    subTotal = subTotal + 0.50;
                }else {
                    subTotal = subTotal - 0.50;
                    System.out.println(caramel.getText() + " removed");
                }
            }
        });
        brownSugar = new JCheckBox("brown sugar (+$0.75)");
        brownSugar.addActionListener(this);
        brownSugar.setBounds(300,165,150,30);
        brownSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (brownSugar.isSelected()) {
                    subTotal = subTotal + 0.75;
                }else {
                    subTotal = subTotal - 0.75;
                    System.out.println(brownSugar.getText() + " removed");
                }
            }
        });

        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(300, 285, 150, 30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);


        orderTextArea = new JTextArea(10, 30);
        orderTextArea.setBounds(400,100,300,200);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        updateOrderTextArea();

        addCart = new JButton("Add to cart?");
        addCart.setBounds(300, 285, 150, 30);
        addCart.setFocusable(false);
        addCart.addActionListener(this);


//        payorder.addActionListener(this);
//        payorder.setBounds(500,300,120,60);
//        payorder.setFocusable(false);

        prepareDrink = new JButton("Prepare Order");
        prepareDrink.setBounds(300, 285, 150, 30);
        prepareDrink.setFocusable(false);
        prepareDrink.addActionListener(this);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);



        frame.add(payorder);
        frame.add(goBack);
        frame.add(label);
        frame.add(comboBox);
        frame.add(label2);
        frame.add(scrollPane);
        frame.add(addCart);
        frame.add(prepareDrink);
        frame.add(vanila);
        frame.add(mocha);
        frame.add(caramel);
        frame.add(brownSugar);
        frame.add(comboBoxCreamer);
        frame.add(comboBoxSize);
        frame.add(total);
        frame.add(Total);
        frame.add(label3);
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
        if(e.getSource()==prepareDrink) {
            frame.dispose();
            Checkout checkout = new Checkout();
        }
    }
    private void updateOrderTextArea() {
        List<String> orders = coffee.loadOrders();
        orderTextArea.setText(String.join("\n", orders));
    }
}
