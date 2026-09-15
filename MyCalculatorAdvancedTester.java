import java.util.Scanner;

public class MyCalculatorAdvancedTester {
    public static void main(String[] args) {

        int Z = 5;
        MyCalculatorAdvanced calc = new MyCalculatorAdvanced();

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the value for X as an integer: ");
        int X = in.nextInt();

        System.out.println("Please enter the value for Y as an integer: ");
        int Y = in.nextInt();

        
        System.out.println("Please enter the value for X as an double: ");
        double XD = in.nextDouble();

        System.out.println("Please enter the value for Y as an double: ");
        double YD = in.nextDouble();

        
        System.out.println("The sum of X and Y is: " + calc.add(X, Y));
        System.out.println("The X - Y is: " + calc.subtract(X, Y));
        System.out.println("The product of X and Y is: " + calc.multiply(X, Y));
        System.out.println("The X divided by Y is: " + calc.divide(X, Y));

        System.out.println("The sum of X and Y is: " + calc.addD(XD, YD));
        System.out.println("The X - Y is: " + calc.subtractD(XD, YD));
        System.out.println("The product of X and Y is: " + calc.multiplyD(XD, YD));
        System.out.println("The X divided by Y is: " + calc.divideD(XD, YD));


        calc.add(X, Y);
        int total = calc.getTotal();
        System.out.println("total is: " + calc.getTotal());
        calc.subtract2(total, 5);
        total = calc.getTotal();
        System.out.println("total is: " + calc.getTotal());

        calc.add(X, Y);
        int totalD = calc.getTotalD();
        System.out.println("total is: " + calc.getTotalD());
        calc.subtract2(total, 5);
        totalD = calc.getTotalD();
        System.out.println("total is: " + calc.getTotal());
    }
}
