public class Comparison {
    public void compFloat2(double number1, double number2){
        number1 = number1 * 100;
        number2 = number2 * 100;

        int standIn1 = (int)number1;
        int standIn2 = (int)number2;
        
        if (standIn1 == standIn2){
            System.out.println("CompFloat2: True");
        } else {
            System.out.println("CompFloat2: False");
        }
    }

    public void compFloat5(double number1, double number2){
        number1 = number1 * 100000;
        number2 = number2 * 100000;

        int standIn1 = (int)number1;
        int standIn2 = (int)number2;
        
        if (standIn1 == standIn2){
            System.out.println("CompFloat5: True");
        } else {
            System.out.println("CompFloat5: False");
        }
    }

    public void compInt(int integer1, int integer2){
        
        if (integer1 == integer2){
            System.out.println("CompInt: True");
        } else {
            System.out.println("CompInt: False");
        }
    }
}
