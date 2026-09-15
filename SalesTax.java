public class SalesTax {
    private double totalCost;
    private double taxRate;

    public SalesTax(){
        totalCost = 0;
        taxRate = 0.5;
    }

    public SalesTax(double tax){
        taxRate = tax;
        totalCost = 0;
    }

    public void calculateTotal(double purchase){
        totalCost = purchase + taxRate;
    }

    public double getTotalCost(){
        return totalCost;
    }
}
