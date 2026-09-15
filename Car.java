import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Car {
    
    private int xLeft;
    private int yTop;
    
    public Car(int x, int y)
    {
        xLeft = x;
        yTop = y;
    }

    

    
    public void draw(Graphics2D g2){

        Rectangle body = new Rectangle(xLeft, yTop + 10, 60, 10);      
        Ellipse2D.Double frontTire  = new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);

        // house section start
        Rectangle houseBody = new Rectangle(xLeft + 110, yTop + 150, 60, 60);
        Rectangle door = new Rectangle(xLeft + 135, yTop + 190, 10, 20);

        Ellipse2D.Double leftWindow  = new Ellipse2D.Double(xLeft + 115, yTop + 160, 15, 15);
        Ellipse2D.Double rightWindow  = new Ellipse2D.Double(xLeft + 150, yTop + 160, 15, 15);

        Point2D.Double lrp1 = new Point2D.Double(xLeft + 110, yTop + 150);
        Point2D.Double lrp2 = new Point2D.Double(xLeft + 140, yTop+ 110);
        Line2D.Double leftRoof = new Line2D.Double(lrp1, lrp2);

        Point2D.Double rrp1 = new Point2D.Double(xLeft + 170, yTop + 150);
        Point2D.Double rrp2 = new Point2D.Double(xLeft + 140, yTop+ 110);
        Line2D.Double rightRoof = new Line2D.Double(rrp1, rrp2);
        //house section end

        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(xLeft + 10, yTop + 10);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(xLeft + 20, yTop);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(xLeft + 40, yTop);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(xLeft + 50, yTop + 10);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);      
        g2.draw(roofTop);      
        g2.draw(rearWindshield); 
        
        //house build start
        g2.draw(houseBody); 
        g2.draw(door);

        g2.draw(leftWindow);
        g2.draw(rightWindow);

        g2.draw(leftRoof);
        g2.draw(rightRoof);
        // house build end
    }

    
}
