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
        String printed = full.substring(0);
        System.out.println(printed);

        printed = full.substring(1);
        System.out.println(printed);

        printed = full.substring(2);
        System.out.println(printed);

        printed = full.substring(3);
        System.out.println(printed);

        printed = full.substring(4);
        System.out.println(printed);

        printed = full.substring(5);
        System.out.println(printed);

        printed = full.substring(6);
        System.out.println(printed);

        printed = full.substring(7);
        System.out.println(printed);

        printed = full.substring(8);
        System.out.println(printed);

        printed = full.substring(9);
        System.out.println(printed);

        printed = full.substring(10);
        System.out.println(printed);

        printed = full.substring(11);
        System.out.println(printed);
    }
}
