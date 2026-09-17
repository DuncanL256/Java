import java.lang.reflect.Array;
import java.util.Arrays;

public class Tester {
    static int NUM_VEHICLES = 10;

    public static void main(String[] args) {
        Vehicle[] list = new Vehicle[NUM_VEHICLES];

        // this is polymorphism because we change from integers to array slots

        for(int i=0; i< NUM_VEHICLES; i++){
            int min = 0; 
            int max = 2; 
            int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);  // generates random number between 0 and 2
            System.out.println(random_int);
            

            list[i] = new Vehicle(random_int);
            
            String type = "";
            if(random_int==0){
                type = "Vehicle";
            } else if(random_int==1){
                type = "Car";
            } else{
                type = "Boat";
            }
            System.out.println(type);
            
            // expected output from instructions makes no sense

            getFirstBelowT(list, 20);
        }
    }
    public static void getFirstBelowT(Array list, double threshold){
        list = list[0];
    }
    
}
