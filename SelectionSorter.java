import java.util.Arrays;
import java.util.Random;

public class SelectionSorter {
    private static void sortList(int[] inputArray) { // has a sorting time of n^2 (n squared)
        for (int i=1; i<inputArray.length; i++){
            
            int currentValue = inputArray[i];
            int j = i-1;

            while (j >= 0 && inputArray[j] > currentValue){
                inputArray[j + 1] = inputArray[j];
                j--;
            } 
            inputArray[j+1] = currentValue;
        }
    }

    


   
   /* public static void sort(int[] a){
        for (int i=0; i< a.length -1; i++){
            int minPos = minimumPosition(a, i);
            //ArayUtil.swap(a, minPos, i);
        }
    }

    private static int minimumPosition(int[] a, int from) {
        int minPos = from;
        for (int i = from +1; i < a.length; i++){
            if (a[i] < a[minPos]) {minPos = i; }
        }

        return minPos;
    } */

    public static void main(String[] args) {
        long start = System.nanoTime(); // nanotime suggestion made by professor instead of professor

        Random rand = new Random();
        int [] arr1 = new int[ 1000000 ];   // Array of size 100

        for (int i=0; i<arr1.length; i++){
            arr1[i] = rand.nextInt(1000);
        }

        System.out.print("Given Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.println(""); // spacer

        sortList(arr1);

        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.println(""); // spacer

        long duration = (System.nanoTime() - start)/1000000;  // the divesion allows us to calculate in milliseconds
        System.out.println(duration + " ms");

        // need to write an algarythm that runs in "n time" and "(n^2-n)/2 time"

    }
}
