public class Change {
    double quarter;
    double dime;
    double nickel;
    double penny;

    public double calculateQuarters(double amount){
        quarter = amount*4;
        return quarter;
    }

    public double calculateDimes(double amount){
        dime = amount*10;
        return dime;
    }

    public double calculateNickel(double amount){
        nickel = amount*20;
        return nickel;
    }

    public double calculatePennys(double amount){
        penny = amount*100;
        return penny;
    }
}
