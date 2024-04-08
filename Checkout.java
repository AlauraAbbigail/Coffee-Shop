import javax.swing.*;
import java.awt.event.ActionListener;

public class Checkout extends Coffee implements ActionListener {
    //prepare() method utilizes polymorphoism to display the order instructions and order information
    JFrame frame = new JFrame();
    JButton prepare = new JButton("Prepare Order");
    JLabel checkout = new JLabel("Welcome to Checkout");
}
