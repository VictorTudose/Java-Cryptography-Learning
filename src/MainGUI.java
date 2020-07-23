import javax.swing.*;

public class MainGUI implements Cloneable{

    public static MainGUI mainGUI;
    public static MainGUI firstPage;

    public static MainGUI getInstance() {
        if(mainGUI==null)
            mainGUI=new MainGUI();
        return mainGUI;
    }
    JFrame frame;

    public MainGUI() {

        mainGUI=this;

        frame=new JFrame("Crypto in Java");

        frame.setSize(Proportions.width,Proportions.height);

        new CipherGUI("MD5").show();
        new CipherGUI("Caesar").show();
        new CipherGUI("Nothing").show();

        frame.setLayout(null);
        frame.setVisible(true);
        try {
            firstPage = (MainGUI) clone();
        }
        catch (Exception e)
        { }
    }

    public void resetFrame()
    {
        for(CipherGUI cipher:CipherGUI.ciphers )
            frame.remove(cipher.chooseMe);
        frame.add(CipherGUI.encrypt);
        frame.add(CipherGUI.ta);
        frame.repaint();
    }


    public static void main(String[] args) {
        new MainGUI();
    };
}