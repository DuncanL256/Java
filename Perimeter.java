import java.awt.Rectangle;

public class Perimeter {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,20,30,30);
        int width = getWidth();
        int height = getHeight();
        int perimeter = width + height + width + height;
        int expected = 120

        System.out.println("expected perimeter: " + expected + "actual perimeter: " + perimeter);
    }
}
