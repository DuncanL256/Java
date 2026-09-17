import java.util.Arrays;
import java.util.Random;

import javax.xml.validation.Validator;

import java.util.ArrayList;

public class ArrayMethod {
    //***NOTE that these methods will change the array itself

    //part a, fill in this method
    public static void swapFirstAndLast(int[] values) {
    // save the first element to a temp var

    int temp = values[0];
    //move the last element to the first position
    values[0] = values[values.length-1];
    // now put the saved first element into the last position
    values[values.length-1] = temp;
    }

    //part b, fill in this method
    public static void shiftRight(int[] values) {
        
        int temp = values[values.length-1];
        
        
        int original = 1;
        int change = 2;
        for ( int i = values.length-1; i>0; i--) {
            values[values.length-original] = values[values.length-change];
            change++;
            original++;
        }
        values[0] = temp; 
    }

    //part c, set all even elements to 0.
    public static void setEvensToZero(int[] values) {
        int testNum = 1;
        for(int i = values.length-1; i>0; i--){
            int temp = values[values.length-testNum];
            if(temp % 2 == 0){
                values[values.length-testNum] = 0;
            }

            testNum++;
        }
    }

    //part d, replace each element except the first and last by larger of two 
    //around it
    public static void largerOfAdjacents(int[] values) {
        int right = 1;
        int same = 2;
        int left = 3;

        for(int i = values.length-2; i>1; i--){
            if(values[values.length - same] < values[values.length - right]){
                values[values.length - same] = values[values.length - right];
            } else if(values[values.length - same] < values[values.length - left]) {
                values[values.length - same] = values[values.length - left];
            }

            
            right++;
            same++;
            left++;
            
        }
    }

    //part e, remove middle el if odd length, else remove middle two els.
    public static int[] removeMiddle(int[] values) {
        int counter = 0;

        for(int i = values.length-1; i>-1; i--)
        {
            counter++;
        }

        
        if(counter % 2 == 0){
            int [] valuesNew = {values[values.length-10], values[values.length-9], values[values.length-8], values[values.length-7], values[values.length-4], values[values.length-3], values[values.length-2] ,values[values.length-1]};
            System.out.println(Arrays.toString(valuesNew));
            values = valuesNew;
        } 

    return null;
    }

    //part f - move all evens to front
    public static void moveEvensToFront(int[] values) {
        int evenCount = values.length;
        int indexNum = 0;
        for(int i = values.length-1; i>1; i--){
            int[] valuesNew = new int[10];
            if(values[values.length - evenCount] % 2 == 0){
                valuesNew[indexNum] = values[values.length - evenCount];
            }
            evenCount++;
            indexNum++;
        }
    }

    //part g - return second largest element in array
    public static int ret2ndLargest(int[] values) {
    // replace this line with your correct return value  COULD NOT SOLVE
    return 0; 
    }

    //part H - returns true if array is sorted in increasing order 
    public static boolean isSorted(int[] values) {
    // replace this line with your correct return value COULD NOT SOLVE
    return false; 
    }

    //PART I - return true if array contains 2 adjacent duplicate values
    public static boolean hasAdjDuplicates(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                if(values[i] == values[j]){
                    for (int k=0; k < values.length; j++){
                        if (values[k] == values[i] && values[k] == values[j]) {
                            System.out.println("Duplicates Present");
                        }
                        
                    }
                }
            }
        }
    return false; //dummy return value
    }

    //PART J - return true if array contains 2 duplicate values
    //duplicates need not be adjacent to return true
    public static boolean hasDuplicates(int[] values) {
    for (int i = 0; i < values.length; i++) {
        for (int j = i+1; j < values.length; j++) {
            if(values[i] == values[j]){
                System.out.println("Duplicates Present");
                return true;
            }
        }
    }
    


    return false;
    }
}

/*public class ArrayMethod {
    public static void main(double[] values) throws Exception {
        int i = 0;
        int j = values.length/2;

        while(i<values.length){
            swap(values, i, j);
            i++;
            j++;
        }
        
    }

    public static void swap(double[] values, int i, int j) {
        double temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void printArray(double[] values, int i, int j) {
        double[]  a = {}
        
        ;
        for(double element: a) {
            System.out.println(element + "");
        }
        System.out.println("");
    }
}*/
