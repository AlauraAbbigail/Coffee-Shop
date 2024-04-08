import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Register implements ActionListener {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int phoneNumber;
    JFrame frame = new JFrame();
    // LABELS
    JLabel title = new JLabel("New Customer Registry");
    JLabel fName = new JLabel("First Name:");
    JLabel lName = new JLabel("Last Name:");
    JLabel resident= new JLabel("Address:");
    JLabel phone = new JLabel("Phone:");
    JLabel userId = new JLabel("UserId:");
    JLabel passWord = new JLabel("Password:");
    JLabel Email = new JLabel("Email:");
    JLabel register = new JLabel("Register");
    JLabel cancel = new JLabel("Cancel");


    //TEXTFIELD
    JTextField fName1 = new JTextField();
    JTextField lName1 = new JTextField();
    JTextField resident1 = new JTextField();
    JTextField phone1 = new JTextField();
    JTextField usertxt = new JTextField();
    JTextField password = new JTextField();
    JTextField Email1 = new JTextField();

    //JBUTTON
    JButton regButton = new JButton("Register");
    JButton cancelButton = new JButton("Cancel");

    Register(){
        // control the location of the jlabel
        // 500 500 is the limit.
        title.setBounds(100,0,500,50);
        title.setFont(new Font(null,Font.BOLD,25));

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

        userId.setBounds(50,210,100,20);
        userId.setFont(new Font(null,Font.BOLD,16));
        usertxt.setBounds(150,210,300,20);

        passWord.setBounds(50,240,100,20);
        passWord.setFont(new Font(null,Font.BOLD,16));
        password.setBounds(150,240,300,20);

        Email.setBounds(50,270,100,20);
        Email.setFont(new Font(null,Font.BOLD,16));
        Email1.setBounds(150,270,300,20);

        register.setBounds(70,340,100,20);
        register.setFont(new Font(null,Font.BOLD,16));
       // REG BUTTON
        regButton.setBounds(50,380,100,40);
        regButton.setFocusable(false);
        regButton.addActionListener(this);

        cancel.setBounds(320,340,100,20);
        cancel.setFont(new Font(null,Font.BOLD,16));
        // CANCEL BUTTON
        cancelButton.setBounds(300,380,100,40);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);


        // to add label to frame
        frame.add(title);
        frame.add(fName);
        frame.add(lName);
        frame.add(resident);
        frame.add(phone);
        frame.add(userId);
        frame.add(passWord);
        frame.add(Email);
        frame.add(register);
        frame.add(cancel);
        //JTEXTFIELD
        frame.add(fName1);
        frame.add(lName1);
        frame.add(resident1);
        frame.add(phone1);
        frame.add(usertxt);
        frame.add(password);
        frame.add(Email1);
        // JBUTTON
        frame.add(regButton);
        frame.add(cancelButton);

        frame.getContentPane().setBackground(Color.GRAY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton) {
            frame.dispose();
            LaunchPage launch = new LaunchPage();
        }
        if(e.getSource()==regButton) {
            frame.dispose();
            NewWindow myWindow = new NewWindow();
        }
    }
}
