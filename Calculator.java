import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, multiButton,divButton;
    JButton decButton, equButton, delButton,clrButton,negButton;
    JPanel panel;
    Font myFont = new Font("SansSerif",Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    boolean isFirstInput = true;
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i =0;i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.WHITE);

        addButton.setBackground(new Color(255,153,204));
        subButton.setBackground(new Color(255,153,0));
        multiButton.setBackground(new Color(255,255,153));
        divButton.setBackground(new Color(153,204,255));
        decButton.setBackground(new Color(204,255,204));
        equButton.setBackground(new Color(204,255,204));
        delButton.setBackground(new Color(204,153,255));
        clrButton.setBackground(new Color(204,153,255));
        negButton.setBackground(new Color(204,153,255));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isFirstInput) {
                    textField.setText("");
                    isFirstInput = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            if (isFirstInput) {
                textField.setText("0");
                isFirstInput = false;
            }
            textField.setText(textField.getText().concat("."));
        }
        for (int i = 0; i < functionButtons.length; i++) {
            if (e.getSource() == functionButtons[i] && i < 4) { // Assuming operator buttons are first four
                num1 = Double.parseDouble(textField.getText());
                operator = functionButtons[i].getText().charAt(0);
                isFirstInput = true;
                break; // Exit the loop after finding the operator button
            }
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==multiButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textField.getText());

            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    if (num1 == 0) {
                        JOptionPane.showMessageDialog(null, "BRUH, What is you doing?");
                    } else if (num2 == 0) {
                        JOptionPane.showMessageDialog(null, "BRUH, What is you doing?");
                    }else {
                        result = num1 / num2;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            isFirstInput = true;
        }
        if(e.getSource()==clrButton) {
            textField.setText("");
            isFirstInput = true;
        }
        if(e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
