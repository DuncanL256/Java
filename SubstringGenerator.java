import java.util.ArrayList;


// This class generates substrings of a string.


public class SubstringGenerator {
    public static ArrayList<String> getSubstrings(String word) {
        //this is the value you will return
        ArrayList<String> result = new ArrayList<String>();
        
        for (int i = 0; i < word.length(); i++) {
            for (int j = i+1; j <= word.length(); j++) {
                //System.out.println(word.substring(i,j));
                result.add(word.substring(i,j));
            }
        }
        
        

        //come up with a base case first
        // Below here is the recursive case
        // Form a simpler word by removing the first character
        // Generate all substrings of the simpler word
        // This is where you will make a recursive call
        // You can store the result from this temporary call in
        // your results ArrayList
        // Add all strings that start with word.charAt(0)
        // You will need a loop here
        // Return all substrings
        return result;
    }
}
