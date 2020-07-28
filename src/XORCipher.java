import javax.swing.*;

public class XORCipher extends Cipher {
    String key;
    int index;

    JButton submit;
    JTextField keyField;

    public char nextXOR()
    {
        index++;
        index = index>=key.length() ? 0 : index;
        return key.charAt(index);
    }


    @Override
    public String encrypt(String string) {

        String outputString = "";

        for (int i = 0; i < string.length(); i++)
        {
            outputString = outputString + Character.toString((char) (string.charAt(i) ^ nextXOR()));
        }

        return outputString;
    }

    @Override
    public void load(JFrame frame) {
        frame.add(submit);
        frame.add(keyField);
    }

    public XORCipher() {
        submit=new JButton("Choose this key");
        keyField=new JTextField();

        submit.setBounds(Layout.firstHalfSlot(1));
        keyField.setBounds(Layout.secondHalfSlot(1));

        try {
            submit.addActionListener(e -> key = keyField.getText());
        }
        catch (NumberFormatException e)
        {
            keyField.setText("Invalid Key");
        }
    }
}
