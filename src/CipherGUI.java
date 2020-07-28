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

        encrypt.setBounds(Layout.fullSlot(0));
        ta.setBounds(Layout.multiSlot(2,4));

        encrypt.addActionListener(
                e -> {

                    ta.setText(cipher.encrypt(ta.getText()));
                }
        );

        ciphers=new ArrayList<>();
    }

    public static void clearText()
    {
        ta.setText("");
    }

    public CipherGUI(String name) {
        this.name=name;
        chooseMe=new JButton(name);
        chooseMe.setBounds(Layout.fullSlot(count));
        count++;

        this.chooseMe.addActionListener(
                e -> {
                    selected=name;
                    MainGUI.mainGUI.secondPage();
                    cipher=Cipher.getCipher(selected);
                    cipher.load(MainGUI.getInstance().getFrame());
                }
        );

        ciphers.add(this);

    }

    public void show()
    {
        MainGUI.mainGUI.getFrame().add(chooseMe);
    }

}