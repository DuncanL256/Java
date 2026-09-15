
public class LoopEx {
    public static void main(String[] args) {
        int days = 1;
        int temp = 67;

        while (days<7){
            temp = temp+5;
            System.out.println("the temperature on day " + days + " is " + temp);
            days++;
        }
    }
}
