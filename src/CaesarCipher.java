import javax.swing.*;

public class CaesarCipher extends NumCipher {

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

}