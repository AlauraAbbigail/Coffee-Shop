import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGui implements ActionListener {
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

    //RadioButton
    JRadioButton premium = new JRadioButton("Are you a Premium customer?");

    //TEXTFIELD
    JTextField fName1 = new JTextField();
    JTextField resident = new JTextField();
    JTextField phone1 = new JTextField();

    //JBUTTON
    JButton viewOrder = new JButton("View order");
    JButton cancelButton = new JButton("Cancel");

    CustomerGui(){
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
        viewOrder.setBounds(50,320,100,40);
        viewOrder.setFocusable(false);
        viewOrder.addActionListener(this);

        // CANCEL BUTTON
        cancelButton.setBounds(300,320,100,40);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);


        // to add label to frame
        frame.add(title);
        frame.add(fName);
        frame.add(address);
        frame.add(resident);
        frame.add(phone);
        frame.add(viewOrder);
        frame.add(premium);
        frame.add(background);
        //JTEXTFIELD
        frame.add(fName1);
        frame.add(resident);
        frame.add(phone1);

        // JBUTTON

        frame.add(cancelButton);
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
            premiumCustomer.payCoffee();
        }

    }
}




        }

    }
}
