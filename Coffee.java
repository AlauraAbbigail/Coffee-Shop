import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coffee implements ActionListener {

    JFrame frame = new JFrame();
    JButton option1 = new JButton("Espresso");
    JButton option2 = new JButton("Filtered Coffee");
    JComboBox comboBox = new JComboBox();
    String[] milkOptions = {"whole milk", "almond milk", "oatmilk"};
    String[] flavors = {"vanilla", "mocha", "caramel", "brown sugar"};
    String[] size = {"12 oz", "16 oz"};
    String[] temp = {"Hot", "Iced"};

    Coffee() {

        option1.setBounds(250, 140, 150, 40);
        option1.setFocusable(false);
        option1.addActionListener(this);

        option2.setBounds(250, 190, 150, 40);
        option2.setFocusable(false);
        option2.addActionListener(this);

        option1.setBackground(new Color(142, 111, 80));
        option2.setBackground(new Color(88,58,41));

        comboBox = new JComboBox();
        comboBox.addActionListener(this);

        frame.add(option1);
        frame.add(option2);

//        getContentPane.setBackground(Color.RED);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==option1) {
            frame.dispose();
            Espresso espressoMenu = new Espresso();
        }
        if(e.getSource()==option2) {
            frame.dispose();
            FilteredCoffee fCMenu = new FilteredCoffee();
        }

    }
}
