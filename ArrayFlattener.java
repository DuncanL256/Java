// Flattens a nested array
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; //These are needed to make and alter the array in the way we need

public class ArrayFlattener {
    
    public static List<Object> flatten(List<Object> nestedList) {
        List<Object> result = new ArrayList<>();
        flattenHelper(nestedList, result);
        return result;
    }
    
    private static void flattenHelper(List<Object> nestedList, List<Object> result) {
        for (Object item : nestedList) {
            if (item instanceof List<?>) {
                // If item is a list, recursively flatten it
                flattenHelper((List<Object>) item, result);
            } else {
                // If item is not a list, add it to the result
                result.add(item);
            }
        }
    }
    
    // Below is the short tester area
    public static void main(String[] args) {
        // Creating the nested list: [1, [2, [3, [4, 5]]], 6]
        List<Object> nested = new ArrayList<>();
        nested.add(1);
        
        List<Object> level1 = new ArrayList<>();
        level1.add(2);
        
        List<Object> level2 = new ArrayList<>();
        level2.add(3);
        
        List<Object> level3 = new ArrayList<>();
        level3.add(4);
        level3.add(5);
        
        level2.add(level3); // the list needs to be populated so it can be altered
        level1.add(level2);
        nested.add(level1);
        nested.add(6);
        
        System.out.println("Nested list: " + nested); // before flattening
        List<Object> flattened = flatten(nested);
        System.out.println("Flattened list: " + flattened); // after flattening 
        
        // Additional test case with a different structure. I figured it would show understnding of the subject.
        List<Object> test2 = Arrays.asList(
            1, 
            Arrays.asList(2, 3),
            4,
            Arrays.asList(5, Arrays.asList(6, 7, 8)),
            9
        );
        
        System.out.println("\nSecond nested list: " + test2);
        List<Object> flattened2 = flatten(test2);
        System.out.println("Second flattened list: " + flattened2);
    }
}
