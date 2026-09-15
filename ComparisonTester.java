import java.util.Scanner;

public class ComparisonTester {
    public static void main(String[] args) {
        System.out.println("Enter first double");
        double number1 = new Scanner(System.in).nextDouble();

        System.out.println("Enter second double");
        double number2 = new Scanner(System.in).nextDouble();

        Comparison uno = new Comparison();
        uno.compFloat2(number1, number2);
        uno.compFloat5(number1, number2);

        System.out.println("Enter first integer");
        int integer1 = new Scanner(System.in).nextInt();

        System.out.println("Enter second integer");
        int integer2 = new Scanner(System.in).nextInt();

        uno.compInt(integer1, integer2);
    }
}
