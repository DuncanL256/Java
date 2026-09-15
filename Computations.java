import java.util.function.IntPredicate;

public class Computations {
    public int computeEvenSums(int stop){
        int sum = 0;

        for (int i = 2; i < stop; i = i+2) {
            System.out.println(i);
        }
    }

    public int sumAllSquares(int stop){
        int sum = 0;

        for (int i = sum; i < stop; i = i+2) {
            System.out.println(i);
        }
        return sum;
    }

    public void calculateAllPowers(int stop){
        double power = 0;
        
        for (int i = 0; i < stop; i = i+2) {
            System.out.println(i);
            power = Math.pow(2, i);
            System.out.println("Two raised to the"  + i + "power is:" + power);
        }
    }
}
