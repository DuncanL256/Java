import java.util.Scanner;

import java.util.Arrays;
import java.util.Random;
public class ArrayMethodTester {
    //helper method to print an array
    public static void printArray(int[] values) {
    System.out.println(Arrays.toString(values));
    }
    public static void main(String[] args) {
    //In your main method you should test your array methods
    //Create an array of size 10

    int[] a = new int[10]; //array of size 1
    //**** Fill the array with random values (use a loop, and a
    //Random object)
    Random fillNum = new Random();

    for (int i = 0; i < 10; i++) {
        a[i] = fillNum.nextInt(100);
    }
    //Now print the array to show initial values
    System.out.println("Random numbers = "+Arrays.toString(a));

    System.out.println("Initial Array:");
    //note the usage of the "toString()" method here to print the array
    System.out.println(Arrays.toString(a));
    //Could replace the previous line with this:
    //printArray(testValues);
    //blank line

    System.out.println();
    //Test methods below this line.
    //Test of swapFirstAndLast()
    
    int[] resetArray = a;

    System.out.println("Before call to swapFirstAndLast():");
    printArray(a);
    int[] b = a.clone();
    int[] c = a.clone();
    int[] d = a.clone();
    int[] e = a.clone();
    int[] f = a.clone();
    int[] g = a.clone();
    int[] h = a.clone();
    int[] i = a.clone();
    int[] j = a.clone();

    //swap first and last element
    //this method modifies the array referenced by "testValues"

    ArrayMethod.swapFirstAndLast(a);
    System.out.println("After call to swapFirstAndLast()");
    printArray(a); //printing the same array but it has changed
    System.out.println();
    
    
    //continue with tests as you complete methods ...

    System.out.println("Before call to shiftRight():");
    printArray(b);
    System.out.println("After call to shiftRight():");
    ArrayMethod.shiftRight(b);
    printArray(b);
    System.out.println();

    System.out.println("Before call to setEvensToZero():");
    printArray(c);
    System.out.println("After call to setEvensToZero():");
    ArrayMethod.setEvensToZero(c);
    printArray(c);
    System.out.println();

    System.out.println("Before call to largerOfAdjacents():");
    printArray(d);
    System.out.println("After call to largerOfAdjacents():");
    ArrayMethod.largerOfAdjacents(d);
    printArray(d);
    System.out.println("COME BACK TO SOLVE THE ONE ABOVE!");
    System.out.println();

    System.out.println("Before call to removeMiddle():");
    printArray(e);
    System.out.println("After call to removeMiddle():");
    ArrayMethod.removeMiddle(e);
    System.out.println();

    /*System.out.println("Before call to moveEvensToFront():");
    printArray(e);
    System.out.println("After call to moveEvensToFront()");
    ArrayMethod.moveEvensToFront(e);
    System.out.println();*/

    System.out.println("Before call to hasAdjDuplicates():");
    printArray(i);
    System.out.println("After call to hasAdjDuplicates():");
    ArrayMethod.hasAdjDuplicates(i);
    System.out.println();

    System.out.println("Before call to hasDuplicates():");
    printArray(j);
    System.out.println("After call to hasDuplicates():");
    ArrayMethod.hasDuplicates(j);
    System.out.println();

    }
}

/*public class ArrayMethodTester {
    public static void main(String[] args) {
        final int SIZE = 100;
        double deux[] = new double [SIZE];
        Scanner in = new Scanner(System.in);
        System.out.println("Input scores, 0 to quit");
        int currentSize = 0;
        while(in.hasNextDouble()){
            if(current.size==a.length) {
                a = Arrays.copyOf(a, 2*a.length);
            }

            a[currentSize] = in.nextDouble();
            currentSize++;
        }

        ArrayMethod.printArray(a);
        System.out.println("before calling swapFirstSecondHalves()");
        ArrayMethod.swapFirstSecondHalves(a);
        System.out.println("after calling swapFirstSecondHalves()");
        ArrayMethod.printArray(a);
    }
    
}*/
