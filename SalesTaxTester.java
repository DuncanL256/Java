public class SalesTaxTester {
    public static void main(String[] args) {
        SalesTax johnsAccount = new SalesTax();
        johnsAccount.calculateTotal(50);
        System.out.println(johnsAccount.getTotalCost());

        SalesTax katesAccount = new SalesTax(0.08);
        katesAccount.calculateTotal(100);
        System.out.println(katesAccount.getTotalCost());
    }
}
