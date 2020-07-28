public class RailFenceCipher extends NumCipher {


    @Override
    public String encrypt(String string) {
        char[][] rail=new char[key][(string.length())];

        for (int i=0; i < key; i++)
            for (int j = 0; j < string.length(); j++)
                rail[i][j] = '\n';

        boolean dir_down = false;
        int row = 0, col = 0;

        for (int i=0; i < string.length(); i++)
        {
            if (row == 0 || row == key-1)
                dir_down = !dir_down;


            rail[row][col++] = string.charAt(i);

            row+= dir_down ? 1 : -1;
        }

        String result="";
        for (int i=0; i < key; i++)
            for (int j=0; j < string.length(); j++)
                if (rail[i][j]!='\n')
                    result+= Character.toString(rail[i][j]);

        return result;
    }
}
