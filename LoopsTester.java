import java.util.Scanner;

public class LoopsTester {
    public static void main(String[] args) {
        Loops one = new Loops();

        System.out.println("enter a stopping value: ");
        int loop1 = new Scanner(System.in).nextInt();

       
        System.out.println(one.usingForLoops(loop1));
        System.out.println(one.usingWhileLoops(loop1));
        System.out.println(one.usingDoLoops(loop1));
    }

    
    
    
}
