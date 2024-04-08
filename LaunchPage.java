import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// template for login page
public class LaunchPage implements ActionListener {

    JFrame frame = new JFrame();

    // title the button to reflect direction to certain class
    JButton myButton = new JButton("MENU");
    JButton regButton = new JButton("Sign up");
    JButton signInButton = new JButton("Login");
    LaunchPage(){
        myButton.setBounds(150,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        regButton.setBounds(10,400,200,40);
        regButton.setFocusable(false);
        regButton.addActionListener(this);

        signInButton.setBounds(270,400,200,40);
        signInButton.setFocusable(false);
        signInButton.addActionListener(this);


        frame.add(myButton);
        frame.add(regButton);
        frame.add(signInButton);
        frame.getContentPane().setBackground(Color.orange);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);



    }
// allow me to go to different pages or classes
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton){
            frame.dispose();
            NewWindow myWindow = new NewWindow();
        }
        if(e.getSource()==regButton) {
            frame.dispose();
            Register newRegister = new Register();
        }
        if (e.getSource()==signInButton){
            frame.dispose();
            SignIn sign = new SignIn();
        }
    }
}
