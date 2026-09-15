public class BankAccountInterest {
    private double balance;
    private double interest;

    public BankAccountInterest(){
        balance = 0;
    }

    public BankAccountInterest(double initialBalance){
        balance = initialBalance;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public double getBalance(){
        return balance;
    }

    // below is the method added for this step
    public void addInterest(double rate){
        interest = balance + rate;
    }

    //intsructions not entirely clears o I made my own modifications to allow it to work to specifications
    public double returnInterest(){
        return interest;
    }
}
