public class MyCalculatorAdvanced {
    int total = 0;
    double totalD = 0;
    
    
    public void clearTotal(){
        total = 0;
        
    }
    public void clearTotalD(){
        totalD = 0;
    }


    public int add(int X, int Y){
        int addReturn = X + Y ;
        total = addReturn;
        return addReturn;
        
    }

    public int subtract(int X, int Y){
        int subtractReturn = X - Y ;
        total = subtractReturn;
        return subtractReturn;
    }

    public int multiply(int X, int Y){
        int multiplyReturn = X * Y ;
        total = multiplyReturn;
        return multiplyReturn;
    }

    public int divide(int X, int Y){
        int divideReturn = X/Y ;
        total = divideReturn;
        return divideReturn;
    }
    
    public double addD(double XD, double YD){
        double addReturn = XD + YD ;
        return addReturn;
    }

    public double subtractD(double XD, double YD){
        double subtractReturn = XD - YD ;
        return subtractReturn;
    }

    public double multiplyD(double XD, double YD){
        double multiplyReturn = XD * YD ;
        return multiplyReturn;
    }

    public double divideD(double XD, double YD){
        double divideReturn = XD / YD ;
        return divideReturn;
    }

   

    public int subtract2(int total, int Z){
        int subtractReturn = total - Z ;
        total = subtractReturn;
        return subtractReturn;
    }

    public int getTotal(){
        return total;
    }

    public double subtract3(double totalD, int Z){
        double subtractReturn = total - Z ;
        totalD = subtractReturn;
        return subtractReturn;
    }

    public int getTotalD(){
        return total;
    }
}
