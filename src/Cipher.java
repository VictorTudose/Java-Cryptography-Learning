import javax.swing.*;
import java.util.HashMap;

class DummyCipher extends Cipher
{
    public String encrypt(String string) {
        return string;
    }

    @Override
    public void load(JFrame frame) { }
}

public abstract class Cipher {
    public static HashMap<String,Cipher> ciphers;
    static {
        ciphers=new HashMap<>();
        ciphers.put("MD5",new MD5Cipher());
        ciphers.put("Caesar",new CaesarCipher());
        ciphers.put("XOR",new XORCipher());
    }
    public abstract String encrypt(String string);
    public abstract void load(JFrame frame);


    public static Cipher getCipher(String cipher)
    {
        Cipher ret=ciphers.get(cipher);

        if(ret==null) {
            return new DummyCipher();
        }
        else {
            return ret;
        }
    }
}
