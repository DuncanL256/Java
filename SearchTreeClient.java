// This program uses the SearchTree class to construct a binary
// search tree of strings and a binary search tree of integers
// and printing out each.

import java.util.*;

public class SearchTreeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SearchTree<String> names = new SearchTree<String>();
        
        // Add names to the tree
        System.out.print("Name (blank to quit)? ");
        String name = console.nextLine();
        while (name.length() > 0) {
            names.add(name);
            System.out.print("Name (blank to quit)? ");
            name = console.nextLine();
        }
        
        System.out.println("\nAlphabetized list:");
        names.print();
        
        // Test search
        System.out.println("\nSearching for a name:");
        System.out.print("Enter name to search: ");
        String searchName = console.nextLine();
        if (names.contains(searchName)) {
            System.out.println("'" + searchName + "' was found in the tree.");
        } else {
            System.out.println("'" + searchName + "' was not found in the tree.");
        }
        
        // Test height and AVL check
        System.out.println("\nTree properties:");
        System.out.println("Height: " + names.height());
        System.out.println("Is AVL: " + names.isAVL());
        
        // Test deletion function
        System.out.println("\nDeleting a name:");
        System.out.print("Enter name to delete: ");
        String deleteName = console.nextLine();
        names.delete(deleteName);
        System.out.println("\nAlphabetized list after deletion:");
        names.print();
        
        // Verify deletion with by searching
        if (names.contains(deleteName)) {
            System.out.println("'" + deleteName + "' is still in the tree.");
        } else {
            System.out.println("'" + deleteName + "' was successfully deleted.");
        }
        
        // Now we do the same for integers
        SearchTree<Integer> numbers = new SearchTree<Integer>();
        System.out.print("\nNext int (0 to quit)? ");
        int number = console.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
        }
        
        System.out.println("\nSorted list:");
        numbers.print();
        
        // Test properties of the created number tree
        System.out.println("\nNumber tree properties:");
        System.out.println("Height: " + numbers.height());
        System.out.println("Is AVL: " + numbers.isAVL());
        
        // Test delete function on number tree
        System.out.print("\nEnter number to delete: ");
        int deleteNumber = console.nextInt();
        numbers.delete(deleteNumber);
        System.out.println("\nSorted list after deletion:");
        numbers.print();
    }
}
