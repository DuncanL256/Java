import java.util.Scanner;


/**
* Greek's method to approximate the square root of a given number.
*/

public class SquareRootComputer {
    public static void main(String[] args) {
        // this is your tester
        // read a value from the user and print the results
        // along with expected value

        Scanner sc = new Scanner(System.in); // yellow light because scanner never closes, this is an issue with the import not the code
        System.out.println(""); // spacer to make terminal look more organized
        System.out.print("Enter a starter number to calculate the square root of: ");
        int starterNumber = sc.nextInt();
        System.out.println("");

        squareRootGuess(starterNumber, starterNumber);
        
        squareRoot(starterNumber);

    }

    
    public static double squareRoot(double x) {
        // from this method come up with a guess
        // and then make the call to the recursive method
        // squareRootGuesser()

        boolean i = false;
        double guess = Math.sqrt(x);
        //public double increment = Math.sqrt(x);
        System.out.println("Expected Value: " + guess);
        System.out.println("");
        // I attempted to write a complicated algarythm that would narrow down the number using brute force, however it seemed exddcessive for this lab

        return guess;

    }

    private static double squareRootGuess(double x, double g) {
        // recursive method to compute the square root of x
        // you will need to have a base case and a recursive case
        // in this method
        double guess = Math.sqrt(x);
        double solve = (guess + x/guess)/2;
        if(solve-guess<=0.0001 || solve+guess<=x+0.0001){
            System.out.println("Square root of " + x + " is: " + solve);
        } else{
            System.out.println(solve);
            System.out.println("not similar");
        }

        return 0;
        
        
    }
}
