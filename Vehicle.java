interface Efficiency {
    
    public double getEfficiency();
    
}

public class Vehicle {
    double efficiency = 0;
    public Vehicle(double number){
        efficiency = number;
    }

    public void printMessage(){
        System.out.println("I am a Vehicle VROOM!!!");
    }

    public static String title = "Vehicle";
    public static String classTitle(){
        return title;
    }

    public void Efficiency(){
        
    }
}
