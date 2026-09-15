import java.util.Scanner;

public class ChangeTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Change money = new Change();
        System.out.println("Enter an amount of money:");
        int amount = in.nextInt();

        System.out.println("quarters: " + money.calculateQuarters(amount));
        System.out.println("dimes: " + money.calculateDimes(amount));
        System.out.println("nickels: " + money.calculateNickel(amount));
        System.out.println("pennys: " + money.calculatePennys(amount));
    }
    
}
