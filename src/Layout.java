import java.awt.*;

public class MainWindow {

    public static int width=840;
    public static int height=810;
    public static int listOffsetX=5;
    public static int listOffsetY=5;
    public static int elementHeight=35;
    public static int slotHeight=40;
    public static int padding=25;

    public static Rectangle fullSlot(int index) {
       return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, width-padding, elementHeight);
    }

    public static Rectangle firstHalfSlot(int index) {
        return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, width/2-padding, elementHeight);
    }

    public static Rectangle secondHalfSlot(int index) {
        return new Rectangle(listOffsetX+width/2, listOffsetY+index*slotHeight, width/2-padding, elementHeight);
    }

    public static Rectangle multiSlot(int index,int count) {
        return new Rectangle(listOffsetX, listOffsetY+index*slotHeight, width-padding, elementHeight);
    }

}
