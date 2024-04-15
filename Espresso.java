import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Espresso extends Coffee implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("You have selected Espresso Menu");
    JButton goBack = new JButton("<");
    JButton latte = new JButton("Latte $5");
    JButton cappuccino = new JButton("Cappuccino $4");
    JLabel labelLatte = new JLabel("Latte");
    JLabel labelCapp = new JLabel("Cappuccino");
    String[] eShots = {"1", "2", "3", "4"};

    Espresso() {

        label.setBounds(0,0,600,50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        goBack.setBounds(640,10,40,40);
        goBack.setFocusable(false);
        goBack.addActionListener(this);

        latte.setBounds(150,140,150,40);
        latte.setFocusable(false);
        latte.addActionListener(this);
        latte.setBackground(new Color(113,162,130));

        cappuccino.setBounds(400,140,150,40);
        cappuccino.setFocusable(false);
        cappuccino.addActionListener(this);
        cappuccino.setBackground(new Color(113,162,130));

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        frame.add(goBack);
        frame.add(label);
        frame.add(labelLatte);
        frame.add(labelCapp);
        frame.add(latte);
        frame.add(cappuccino);
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
        if(e.getSource()==latte) {
            frame.dispose();
            Latte latteMenu = new Latte();
        }
        if(e.getSource()==cappuccino) {
            frame.dispose();
            Cappuccino cappMenu = new Cappuccino();
        }
    }
}
