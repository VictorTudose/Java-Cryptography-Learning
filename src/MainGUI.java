import javax.swing.*;

public class MainGUI implements Cloneable{

    public static MainGUI mainGUI;

    public static MainGUI getInstance() {
        if(mainGUI==null)
            mainGUI=new MainGUI();
        return mainGUI;
    }
    JFrame frame;
    JButton back;


    public MainGUI() {

        mainGUI=this;

        frame=new JFrame("Crypto in Java");
        frame.setSize(Layout.width, Layout.height);

        new CipherGUI("MD5").show();
        new CipherGUI("Caesar").show();
        new CipherGUI("Nothing").show();

        frame.setLayout(null);
        frame.setVisible(true);

        back=new JButton("Back");
        back.setBounds(5, Layout.height-2* Layout.elementHeight-15, Layout.width, Layout.elementHeight);

        back.addActionListener(
                e->firstPage()
        );

    }

    public void firstPage()
    {
        frame.getContentPane().removeAll();
        for(CipherGUI cipher:CipherGUI.ciphers )
            frame.add(cipher.chooseMe);
        frame.repaint();
    }

    public void secondPage()
    {
        for(CipherGUI cipher:CipherGUI.ciphers )
            frame.remove(cipher.chooseMe);
        frame.add(CipherGUI.encrypt);
        frame.add(CipherGUI.ta);
        frame.add(back);
        frame.repaint();
    }


    public static void main(String[] args) {
        new MainGUI();
    };
}