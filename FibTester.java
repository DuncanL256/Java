import java.util.Scanner;

public class FibTester {
    public static void main(String[] args) {
        System.out.println("What number do you want to use to calculate the Fibonacci value: ");
        int num = new Scanner(System.in).nextInt();

        Fib fib = new Fib();
        fib.calcFib(num);
    }
}
