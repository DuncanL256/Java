import java.util.Scanner;

public class TaxCalculator {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your income: ");
        double income = in.nextDouble();

        System.out.print("Are you married? Y/N");
        String input = in.next();
        int status;
        
        if (input.equals("Y")){
            status = TaxReturn.MARRIED;
        } else {
            status = TaxReturn.SINGLE;
        }
        TaxReturn aTaxreturn = new TaxReturn(income, status);
        System.out.println("tax: " + aTaxreturn.getTax());
    }
}
