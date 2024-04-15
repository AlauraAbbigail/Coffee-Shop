import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Checkout implements ActionListener {
    private String filePath;
    private static final String CSV_FILE_PATH = "orderH.csv";
    JLabel title = new JLabel("Checkout");
    JTextArea invoice = new JTextArea();
    JButton receipt = new JButton("Receipt");
    JButton Exit = new JButton("Exit");
    ImageIcon pic = new ImageIcon(getClass().getResource("Coffee_Background.png"));
    Image icon = pic.getImage();
    Image scaledImage = icon.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
    JLabel background = new JLabel(new ImageIcon(scaledImage));
    Coffee coffee;
    public Checkout(){
        //LADARIUS PATRICK
        coffee= new Coffee(CSV_FILE_PATH);
        System.out.println(coffee.loadOrders());
        JFrame frame = new JFrame();
        title.setBounds(450,0,500,40);
        title.setFont(new Font(null,Font.BOLD,20));
        invoice.setBounds(200,200,500,300);


        //LADARIUS PATRICK
        JScrollPane scrollPane = new JScrollPane();
        receipt.setBounds(320,100,100,40);
        receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==receipt){;
                    JOptionPane.showMessageDialog(null, coffee.loadOrders());
                }
            }
        });

        background.setBounds(0,0,700,400);
        background.setFocusable(false);
        background.setVisible(true);

        Exit.setBounds(320,320,100,40);
        Exit.setFocusable(false);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(frame,"You want to exit the CoffeeShop?","Confirm Exit",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        frame.add(receipt);

        frame.add(Exit);
        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
