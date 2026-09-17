import java.util.ArrayList;

public class ArrayListMethods {
    // Task 1 removeEvenLength: Remove strings of even length
    public static void removeEvenLength(ArrayList<String> list) {
        // not exactly confident why str -> is needed but its the only solution ive been able to find that makes the parameter work
        list.removeIf(str -> str.length() % 2 == 0); // perameter divides the length of each string by 2
        // if string can be evenly divided by 2 it is removed from the list
    }

    // Task 2 doubleList: Double each string in the list
    public static void doubleList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i += 2) { // i use this to itterate through ArrayList two at a time (hence += 2)
            String current = list.get(i); //whatever elected string is chosen here
            list.add(i + 1, current);
        }
    }

    // Task 3 removeDuplicates: Remove duplicates from sorted list
    public static void removeDuplicates(ArrayList<String> list) {
        for (int i = list.size() - 1; i > 0; i--) { // this for loop is designed to itterate backwards
            if (list.get(i).equals(list.get(i - 1))) { // it goes on to compare each element with the element before it
                list.remove(i); // the element is removed if they are duplicates, probably only works if the list is pre sorted, i havent tried an unsorted list
            }
        }
    }

    // Task 4 removeInRange: Remove strings alphabetically between start and end
    public static void removeInRange(ArrayList<String> list, String start, String end) {
        list.removeIf(str -> str.compareTo(start) >= 0 && str.compareTo(end) <= 0); //the string at the start is compared between the start and the ending strings
        // if applicable the string is removed from the list
    }

    // Task 5 markLength4: Mark strings of length 4 with asterisks
    public static void markLength4(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) { //the length is checked to see if it is or is not 4
                list.add(i, "****"); // an element is inserted before the element with a length of 4
                i++; //i is increased so we can continue through the list
            }
        }
    }

    // Main method to demonstrate all methods
    
    //
    public static void main(String[] args) {
        // Demonstration for removeEvenLength
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("removeEvenLength Task");
        list1.add("a"); // Originally I was going to alter the same main list, but it became easier to fill the lists based on what each task needed
        list1.add("bb");
        list1.add("ccc");
        list1.add("dddd");
        System.out.println("Before removeEvenLength: " + list1);
        removeEvenLength(list1);
        System.out.println("After removeEvenLength: " + list1);

        // Demonstration for doubleList
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println("\ndoubleList Task"); // I added some spacers here so that it looks better in the terminal
        list2.add("how");
        list2.add("are");
        list2.add("you?");
        System.out.println("Before doubleList: " + list2);
        doubleList(list2);
        System.out.println("After doubleList: " + list2);

        // Demonstration for removeDuplicates
        ArrayList<String> list3 = new ArrayList<>();
        System.out.println("\nremoveDuplicates Task");
        list3.add("be");
        list3.add("be");
        list3.add("is");
        list3.add("not");
        list3.add("or");
        list3.add("question");
        list3.add("that");
        list3.add("the");
        list3.add("to");
        list3.add("to");
        System.out.println("Before removeDuplicates: " + list3);
        removeDuplicates(list3);
        System.out.println("After removeDuplicates: " + list3);

        // Demonstration for removeInRange
        ArrayList<String> list4 = new ArrayList<>();
        System.out.println("\nremoveInRange Task");
        list4.add("to");
        list4.add("be");
        list4.add("or");
        list4.add("not");
        list4.add("to");
        list4.add("be");
        list4.add("that");
        list4.add("is");
        list4.add("the");
        list4.add("question");
        System.out.println("Before removeInRange: " + list4);
        removeInRange(list4, "free", "rich");
        System.out.println("After removeInRange: " + list4);

        // Demonstration for markLength4
        ArrayList<String> list5 = new ArrayList<>();
        System.out.println("\nmarkLength4 Task");
        list5.add("this");
        list5.add("is");
        list5.add("lots");
        list5.add("of");
        list5.add("fun");
        list5.add("for");
        list5.add("Java");
        list5.add("coders");
        System.out.println("Before markLength4: " + list5);
        markLength4(list5);
        System.out.println("After markLength4: " + list5);
    }
}