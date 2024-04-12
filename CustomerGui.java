import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerGui implements ActionListener {

    JFrame frame = new JFrame();
    //background image made by Alaura Buzbee
    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
    Image icon = pic.getImage();
    Image scaledImage = icon.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
    JLabel background = new JLabel(new ImageIcon(scaledImage));
    JLabel title = new JLabel("Customer Info");
    JLabel fName = new JLabel("First Name:");
    JLabel lName = new JLabel("Last Name:");
    JLabel resident= new JLabel("Address:");
    JLabel phone = new JLabel("Phone:");

    JLabel Email = new JLabel("Email:");
    JLabel register = new JLabel("Register");
    JLabel cancel = new JLabel("Cancel");
    JRadioButton premium = new JRadioButton("Are you a Premium customer?");
    JRadioButton regular = new JRadioButton();


    //TEXTFIELD
    JTextField fName1 = new JTextField();
    JTextField lName1 = new JTextField();
    JTextField resident1 = new JTextField();
    JTextField phone1 = new JTextField();

    JTextField Email1 = new JTextField();

    //JBUTTON
    JButton regButton = new JButton("Pay order");
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

        lName.setBounds(50,120,100,20);
        lName.setFont(new Font(null,Font.BOLD,16));
        lName1.setBounds(150,120,300,20);

        resident.setBounds(50,150,100,20);
        resident.setFont(new Font(null,Font.BOLD,16));
        resident1.setBounds(150,150,300,20);

        phone.setBounds(50,180,100,20);
        phone.setFont(new Font(null,Font.BOLD,16));
        phone1.setBounds(150,180,300,20);

        Email.setBounds(50,210,100,20);
        Email.setFont(new Font(null,Font.BOLD,16));
        Email1.setBounds(150,210,300,20);

        // REG BUTTON
        regButton.setBounds(50,320,100,40);
        regButton.setFocusable(false);
        regButton.addActionListener(this);

        // CANCEL BUTTON
        cancelButton.setBounds(300,320,100,40);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);


        // to add label to frame
        frame.add(title);
        frame.add(fName);
        frame.add(lName);
        frame.add(resident);
        frame.add(phone);
        frame.add(Email);
        frame.add(register);
        frame.add(cancel);
        frame.add(premium);
        frame.add(background);
        //JTEXTFIELD
        frame.add(fName1);
        frame.add(lName1);
        frame.add(resident1);
        frame.add(phone1);
        frame.add(Email1);
        // JBUTTON
        frame.add(regButton);
        frame.add(cancelButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==premium){


        }

    }
}
