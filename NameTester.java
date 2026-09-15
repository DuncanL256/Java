import java.util.Scanner;

public class NameTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName = in.next();
        System.out.println("First name inputed: " + firstName);

        String blank = " ";

        String lastName = in.next();
        System.out.println("Last name inputed: " + lastName);

        System.out.println("yuh");

        String full = firstName + blank + lastName;
        
        int index = 0;
        for (int i = 0; i < full.length(); i++) {
            
            int end = index + 1;

            String printed = full.substring(index, end);
            System.out.println(printed);

            index++;
        }
        
        
    }
}
