import java.awt.*;

public class Layout {

    static
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
    }

    public static int screenWidth;
    public static int screenHeight;

    public static int width=screenWidth/2;
    public static int height=screenHeight/2;
    public static int listOffsetX=screenWidth/200;
    public static int listOffsetY=screenHeight/200;
    public static int elementHeight=screenHeight/25-listOffsetY;
    public static int slotHeight=screenHeight/25;
    public static int padding=25;
    public static int margin=15;

    public static void update()
    {

        width=screenWidth/2;
        height=screenHeight/2;
        listOffsetX=screenWidth/100;
        listOffsetY=screenHeight/100;
    }

    private static int elementWidth()
    {
        return width-listOffsetX-padding;
    }

    public static Rectangle fullSlot(int index) {
       return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, elementWidth(), elementHeight);
    }

    public static Rectangle firstHalfSlot(int index) {
        return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, width/2-padding, elementHeight);
    }

    public static Rectangle secondHalfSlot(int index) {
        return new Rectangle(listOffsetX+width/2, listOffsetY+index*slotHeight, width/2-padding, elementHeight);
    }

    public static Rectangle multiSlot(int index,int count) {
        return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, elementWidth(), elementHeight*count);
    }

    public static Rectangle revFullSlot(int index) {
        return new Rectangle(listOffsetX, height-listOffsetY-elementHeight-padding-margin-index*slotHeight, elementWidth(), elementHeight);
    }

    class Tab
    {
        int count;

        public Rectangle nextSlot()
        {
            return fullSlot(count++);
        }

        public Rectangle nextHalfSlot()
        {
            return firstHalfSlot(count++);
        }

        public void skip()
        {
            count++;
        }
    }

}
