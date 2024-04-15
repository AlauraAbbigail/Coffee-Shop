import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Espresso extends Coffee implements ActionListener {

    JFrame frame = new JFrame();
    //placeholder JLabel label = new JLabel("You have selected Espresso Menu");
    JButton goBack = new JButton("<");

    JButton latte = new JButton("Latte");
    JButton cappuccino = new JButton("Cappuccino");
    JLabel labelLatte = new JLabel("Latte");
    JLabel labelCapp = new JLabel("Cappuccino");
    String[] eShots = {"1", "2 (standard)", "3 (+$0.75)", "4 (+$1.50)"};

    ImageIcon picE = new ImageIcon(getClass().getResource("espressoMenuImage.png"));
    Image iconE = picE.getImage();
    Image scaledImageE = iconE.getScaledInstance(550,60, Image.SCALE_SMOOTH);
    JLabel bannerE = new JLabel(new ImageIcon(scaledImageE));

    Espresso() {

        bannerE.setBounds(25,5,600,70);
        bannerE.setFocusable(false);
        bannerE.setVisible(true);

        goBack.setBounds(630,10,50,50);
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
        frame.add(bannerE);
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