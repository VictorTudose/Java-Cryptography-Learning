import javax.swing.*;

public class CaesarCipher extends Cipher {
    int key;

    JButton submit;
    JTextField keyField;

    public String encrypt(String string)
    {
        StringBuilder sb=new StringBuilder(string);
        for(int i=0; i<sb.length();i++)
        {
            char base=0;
            if(sb.charAt(i)<='z' && sb.charAt(i)>='a')
                base='a';
            if(sb.charAt(i)<='Z' && sb.charAt(i)>='A')
                base='A';
            if( (sb.charAt(i)<='Z' && sb.charAt(i)>='A')||(sb.charAt(i)<='z' && sb.charAt(i)>='a') )
            {
                char c=sb.charAt(i);
                c-=base;
                c+=key;
                c%=26;
                c+=base;
                sb.setCharAt(i,c);
            }
        }
        return sb.toString();
    }

    public CaesarCipher() {
        submit=new JButton("Choose this key");
        keyField=new JTextField();

        submit.setBounds(5,5+Proportions.elementHeight+5,Proportions.width/2-25,Proportions.elementHeight);
        keyField.setBounds(5+Proportions.width/2,5+Proportions.elementHeight+5, Proportions.width/2-25,Proportions.elementHeight);

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