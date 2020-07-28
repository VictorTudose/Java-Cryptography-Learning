import javax.swing.*;

public abstract class NumCipher extends Cipher{
    int key;

    JButton submit;
    JTextField keyField;

    public abstract String encrypt(String string);

    public NumCipher() {
        submit=new JButton("Choose this key");
        keyField=new JTextField();

        submit.setBounds(Layout.firstHalfSlot(1));
        keyField.setBounds(Layout.secondHalfSlot(1));

        try {
            submit.addActionListener(e -> key = Integer.parseInt(keyField.getText()));
        }
        catch (NumberFormatException e)
        {
            keyField.setText("Invalid Key");
        }
    }

    @Override
    public void load(JFrame frame) {
        frame.add(submit);
        frame.add(keyField);
    }


}
