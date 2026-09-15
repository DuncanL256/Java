

public class Tip {
    int satisfactionRating;

    public void satisfactionSet(int rate){
        satisfactionRating = rate;
    }

    public double calculateBill(int mealCost, int satisfactionCost){
        double calcTip = 0;
        if (satisfactionCost == 1){
            calcTip = mealCost + (mealCost * 0.20);
        } else if (satisfactionCost == 2){
            calcTip = mealCost + (mealCost * 0.15);
        } else if (satisfactionCost == 3){
            calcTip = mealCost + (mealCost * 0.10);
        }
        
        System.out.println("Final Price with tip is: " + calcTip);
        return calcTip;
    }
}
