import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("input a X:");
        double X = in.nextDouble();
        System.out.print("input a Y:");
        double Y = in.nextDouble();
        
        X = Math.round(X * 100);
        X = X / 100;

        Y = Math.round(Y * 100);
        Y = Y / 100;

        if (X == Y)
        {
            System.out.println("These numbers are similar");
        }
        else
        {
            System.out.println("These numbers are different");
        }
    }
}
