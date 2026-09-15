import java.util.Scanner;

public class TipTester {
    public static void main(String[] args) {
        System.out.println("Enter the cost of your meal");
        int mealCost = new Scanner(System.in).nextInt();

        System.out.println("Now enter a satisfaction rating for yopur meal, 1 being the best 3 being the worst: ");
        int satisfactionCost = new Scanner(System.in).nextInt();

        
        Tip diner = new Tip();
        diner.calculateBill(mealCost, satisfactionCost);
        //System.out.println(calcTip);
    }
}
