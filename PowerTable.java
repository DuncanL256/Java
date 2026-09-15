import java.util.Random;

public class PowerTable {
    public static void main(String[] args){  
        final int NMAX = 4;
        final double XMAX = 15;

        for (int n = 1; n <= NMAX; n++){
            System.out.printf("%10d", n);
        }
        System.out.println();
        for (int n = 1; n <= NMAX; n++){
            System.out.printf("%10s", "x ");
        }
        System.out.println();

        for (double x = 1; x <= XMAX; x++){
            for (int n = 1; n <= NMAX; n++){
                System.out.printf("%10.0f", Math.pow(x, n));
            }
            System.out.println();
        }
        System.out.println("im like that mf");
//__________________________________________________________________________________________________________________________________________________
        for (int i=1; i<= 3; i++){
            for (int j=1; j<=4; j++){
                System.out.print("[]");
            }
            System.out.println();
        }
//______________________________________________________________________________________________________________________________________________
        
    
    }

}
