import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cappuccino extends Espresso implements ActionListener {
    JFrame frame = new JFrame();
    JButton goBack = new JButton("<--");
    JLabel labelMilk = new JLabel("Select Milk Type: ");
    JComboBox comboBox = new JComboBox();

    Cappuccino() {

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        labelMilk.setBounds(50,45,150,25);
        labelMilk.setFont(new Font(null, Font.BOLD,15));

        comboBox = new JComboBox(milkOptions);
        comboBox.addActionListener(this);
        comboBox.setBounds(50,75,150,30);

        frame.add(goBack);
        frame.add(labelMilk);
        frame.add(comboBox);

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
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
