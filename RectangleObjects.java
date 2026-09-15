import java.awt.Rectangle;

public class RectangleObjects {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,20,30,30);
        int width = getWidth();
        int height = getHeight();
        int x = getX();
        int y = getY();

        System.out.println("width: " + width + ", height: " + height + "x: " + x + "y: " +y);

        Typebox.translate(10,15);

        System.out.println("width: " + width + ", height: " + height + "x: " + x + "y: " +y);
    }
    

}
