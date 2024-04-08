import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignIn implements ActionListener {
    JFrame frame = new JFrame();
    JPanel orangePanel = new JPanel();
    JLabel title = new JLabel("The CoffeeShop!");
    JLabel userId = new JLabel("UserName:");
    JLabel done = new JLabel("Done");
    JLabel passWord = new JLabel("Password:");
    JLabel premiumPass = new JLabel("Are you a premium customer?");
    JRadioButton premiumpass = new JRadioButton();
    JLabel newCustomer = new JLabel("Are you a new customer?");
    JRadioButton CUpass = new JRadioButton();
    JTextField usertxt = new JTextField();
    JPasswordField passtxt = new JPasswordField();
    ButtonGroup group = new ButtonGroup();
    JButton doneButton = new JButton();

    SignIn(){

        //Orange Panel
        orangePanel.setBackground(Color.ORANGE);
        orangePanel.setBounds(0,0,500,500);
        orangePanel.setLayout(new BorderLayout());

        title.setBounds(100,0,500,100);
        title.setFont(new Font(null,Font.BOLD,25));
        title.setBackground(Color.orange);
        // USERID
        userId.setBounds(10,200,100,20);
        userId.setFont(new Font(null,Font.BOLD,16));
        usertxt.setBounds(100,200,300,20);
        // PASSWORD
        passWord.setBounds(10,230,100,20);
        passWord.setFont(new Font(null,Font.BOLD,16));
        passtxt.setBounds(100,230,300,20);

        premiumPass.setBounds(20,300,300,20);
        premiumPass.setFont(new Font(null,Font.BOLD,16));
        premiumpass.setBounds(20,320,40,20);
        premiumpass.setBackground(Color.GRAY);

        newCustomer.setBounds(300,300,300,20);
        newCustomer.setFont(new Font(null,Font.BOLD,16));
        CUpass.setBounds(300,320,100,20);
        CUpass.setBackground(Color.GRAY);
        CUpass.setFocusable(false);
        CUpass.addActionListener(this);

        done.setBounds(400,400,100,20);
        done.setFont(new Font(null,Font.BOLD,16));
        doneButton.setBounds(400,450,100,100);



        group.add(premiumpass);
        group.add(CUpass);

        frame.add(title);
        frame.add(userId);
        frame.add(usertxt);
        frame.add(passWord);
        frame.add(passtxt);
        frame.add(premiumPass);
        frame.add(newCustomer);
        frame.add(premiumpass);
        frame.add(CUpass);
        frame.add(done);
        frame.add(doneButton);

        frame.getContentPane().setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== CUpass){
            frame.dispose();
            Register newReg = new Register();
        }

    }
}
