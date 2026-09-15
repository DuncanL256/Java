import java.util.Scanner;

public class ComputationTester {
    public static void main(String[] args) {

        Computations one = new Computations();

        System.out.println("Enter an value to stop computing the sum of the squares");
        int end = new Scanner(System.in).nextInt();
        int sum = 0;

        sum = one.sumAllSquares(end);
        System.out.println("the sum of squares from 0 to " + end + " is " + sum);
        
        // some requests cannot be carried out because the lab asks for fuctions that do not exist
    }
}
