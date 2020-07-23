import javax.swing.*;
import java.security.MessageDigest;


public class MD5Cipher extends Cipher {

    public static String bytesToHex(byte[] bytes) {
        final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    @Override
    public String encrypt(String string) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte[] digest = md.digest();
            String myHash = bytesToHex(digest).toUpperCase();
            return myHash;

        }
        catch (Exception e)
        {

            return string;
        }
    }

    @Override
    public void load(JFrame frame) { }
}
