import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainGUI implements Cloneable{

    public static MainGUI mainGUI;

    public static MainGUI getInstance() {
        if(mainGUI==null)
            mainGUI=new MainGUI();
        return mainGUI;
    }
    private JFrame frame;
    private JButton back;

    public JFrame getFrame() {
        return frame;
    }

    public Rectangle getSize()
    {
        return frame.getBounds();
    }

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
        back.setBounds(Layout.revFullSlot(0));

        back.addActionListener(
                e->firstPage()
        );

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                Layout.update();
            }
        });


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