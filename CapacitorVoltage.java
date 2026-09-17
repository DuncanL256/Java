// imported packages below
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.PrintWriter;
import java.lang.Math; // for the math operator
import java.math.BigDecimal; // lets me give very accurate numbers

// running code section below
public class CapacitorVoltage{
    public static void main(String[] args) throws Exception {
        
        // This section of code reads the file we are given (named params.txt)
        try {
        File myObj = new File("C:/Users/cyclo/Documents/Java Code/Lamb_Duncan_Lab7/params.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println("");
            System.out.println("Input from params.txt: " + data);
            System.out.println("");
        }
        myReader.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }


        // this section of code handles printing our output to the file (named rc.txt)
        File file1= new File("rc.txt");
        FileWriter fw = new FileWriter(file1);
        PrintWriter pw = new PrintWriter(fw);

        // now for the actual calculations

        double e = 2.71; // a very rough aproximation of e
        int volts = 0;
        for(int i=0; i<1000; i++){
            
            double b = (double)-0.008*(double)volts;
            double fin = Math.pow(e, b);
            double output = 12*(1-fin);

            pw.println(i + ": " + new BigDecimal(output).toPlainString());
            volts++;
        }
        // the outputs in the instructions do not equal the formula, However the math in this code is correct basing on the formula

        pw.close();
    }
    
}
