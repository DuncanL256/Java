import java.util.Arrays;
import java.util.ArrayList;

public class ARX {
    
    public static void addScores(int[] values){
        int totalScore = 0;
        for (int i = 0; i < values.length; i++){
            totalScore = totalScore + values[i];
        }
        System.out.println(totalScore);
    }

    public static void main(String[] args) {
        int [] x = new int[10];
        x[4] = 56;
        x[8] = 23;
        System.out.println(x[4]);
        System.out.println(Arrays.toString(x));

        String [] names = {"good", "r", "t"};
        String [] trys = new String[6];
        System.out.println(Arrays.toString(names));
        System.out.println(names.length);

//________________________________________________________________________________________________________

        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println(" ");
        System.out.println(nums);
        nums.add(12);
        nums.add(56);
        System.out.println(nums);

    }
}
