import java.util.Arrays;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000, 10000000}; // array sizes to test
        //StopWatch stopwatch = new StopWatch(); // stopwatch class provided in book

        // iterate through each array size
        for (int size : sizes) {
            int[] arr = new int[size];

            // fill the array with random numbers
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * 1000);
            }

            // selection sort
            //stopwatch.start();
            long start = System.nanoTime();
            selectionSort(arr);
            //stopwatch.stop();
            long selectionTime = (System.nanoTime() - start)/1000000;

            // merge sort
            //stopwatch.start();
            long start2 = System.nanoTime();
            mergeSort(arr);
            //stopwatch.stop();
            long mergeTime = (System.nanoTime() - start)/1000000;

            // Arrays.sort() method
            //stopwatch.start();
            long start3 = System.nanoTime();
            Arrays.sort(arr);
            //stopwatch.stop();
            long arraysSortTime = (System.nanoTime() - start)/1000000;

            // output results to console
            System.out.println("Array size: " + size);
            System.out.println("Selection sort time: " + selectionTime + " ms");
            System.out.println("Merge sort time: " + mergeTime + " ms");
            System.out.println("Arrays.sort() time: " + arraysSortTime + " ms");
            System.out.println(""); // spacer
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
    }
}

