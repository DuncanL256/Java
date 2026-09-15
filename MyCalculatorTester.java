import java.util.Scanner;

public class MyCalculatorTester {
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();

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
    }
}
