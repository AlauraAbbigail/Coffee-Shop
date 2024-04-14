import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cappuccino extends Espresso implements ActionListener {
    private double total;
    private double subtotal= 0.0;
    private final double cappuccino = 5.00;
    JFrame frame = new JFrame();
    JButton goBack = new JButton("<");
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JComboBox comboBox = new JComboBox();
    JButton addCart = new JButton("Add to cart?");
    JButton cart = new JButton();
    JCheckBox vanila= new JCheckBox("Vanila $1.00");
    JCheckBox mocha = new JCheckBox("Mocha  $2.00");
    JCheckBox caramel = new JCheckBox("Caramel  $3.00");
    JCheckBox brownSugar = new JCheckBox("Brown Sugar   $5.00");
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JTextField CapTotal = new JTextField();
    JTextField CapSub = new JTextField();

    Cappuccino() {
        //subtotal and total LABEL THEM LATER.
        CapSub.setBounds(50,200,300,30);
        CapTotal.setBounds(50,300,300,30);

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        cart.setBounds(590,10,40,40);
        cart.setFocusable(false);
        cart.addActionListener(this);

        labelMilk.setBounds(50,45,150,25);
        labelMilk.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(milkOptions);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);

        addCart = new JButton("Add to cart?");
        addCart.setBounds(300, 285, 150, 30);
        addCart.setFocusable(false);
        addCart.addActionListener(this);

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        frame.add(goBack);
        frame.add(labelMilk);
        frame.add(comboBox);
        frame.add(CapTotal);
        frame.add(CapSub);
        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(vanila.isSelected()) {
            subtotal = subtotal + 1.00;
        } else if (mocha.isSelected()) {
            subtotal = subtotal + 2.00;
        } else if (caramel.isSelected()) {
            subtotal = subtotal+3.00;
        }else if (brownSugar.isSelected()) {
            subtotal = subtotal + 5.00;
        }
        CapSub.setText(Double.toString(subtotal));
        subtotal= Double.parseDouble(CapSub.getText());
        total= cappuccino+subtotal;
        CapSub.setText(Double.toString(subtotal));
        CapTotal.setText(Double.toString(total));
        if (e.getSource() == goBack) {
            frame.dispose();
            Espresso espressoMenu = new Espresso();
        }
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
