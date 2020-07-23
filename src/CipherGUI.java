import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CipherGUI {
    public static int count;

    String name;
    JButton chooseMe;

    static JButton encrypt;
    static JTextArea ta;
    static String selected;
    static  Cipher cipher;

    static ArrayList<CipherGUI> ciphers;

    static
    {
        encrypt=new JButton("Encrypt");
        ta=new JTextArea();

        encrypt.setBounds(5,5,Proportions.width-25,Proportions.elementHeight);
        ta.setBounds(5,5+3*Proportions.elementHeight,Proportions.width,Proportions.height/2);

        encrypt.addActionListener(
                e -> {

                    ta.setText(cipher.encrypt(ta.getText()));
                }
        );

        ciphers=new ArrayList<>();
    }

    public CipherGUI(String name) {
        this.name=name;
        chooseMe=new JButton(name);
        chooseMe.setBounds(Proportions.listOffsetX,Proportions.listOffsetY+40*count,Proportions.width-25,Proportions.elementHeight);
        count++;

        this.chooseMe.addActionListener(
                e -> {
                    selected=name;
                    MainGUI.mainGUI.resetFrame();
                    cipher=Cipher.getCipher(selected);
                    cipher.load(MainGUI.getInstance().frame);
                }
        );

        ciphers.add(this);

    }

    public void show()
    {
        MainGUI.mainGUI.frame.add(chooseMe);
    }

}