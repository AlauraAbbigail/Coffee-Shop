import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class IDandPassword{
    SignIn sign = new SignIn();
    HashMap<String,String>logininfo = new HashMap<String,String>();
    Scanner input = new Scanner(System.in);
    IDandPassword(){
        logininfo.put(sign.userId.getText(), Arrays.toString(sign.passtxt.getPassword()));
    }
    public HashMap getLoginInfo(){
        return logininfo;
    }
}