// Searches for words in a dictionary text file
// and reports each word's position in the file.

import java.io.*;
import java.util.*;

public class WordChallenge {
    public static void main(String[] args)
            throws FileNotFoundException {
        System.out.println("Welcome to Scrabble word challenge!");

        // read a sorted dictionary file into a List
        Scanner in = new Scanner(new File("words.txt"));
        List<String> words = new ArrayList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }

        // binary search the list for words
        Scanner console = new Scanner(System.in);
        System.out.print("Word to challenge (Enter to quit)? ");
        String target = console.nextLine();
        while (target.length() > 0) {
            int index = Collections.binarySearch(words, target);
            if (index >= 0) {
                System.out.println("\"" + target + "\" is word #"
                        + index + " of " + words.size());
            } else {
                System.out.println("\"" + target + "\" is not found");
            }
            
            System.out.print("Word to challenge (Enter to quit)? ");
            target = console.nextLine();
        }


        // Converted list to array for use in our methods
        String[] wordsArray = words.toArray(new String[0]);

        // below is the functionality for Problem 1 and Problem 2
        System.out.print("Enter a letter to find frequency: ");
        char letter = console.nextLine().charAt(0);
        
        // Calculate and display frequency (Problem 1)
        int frequency = calculateFrequency(wordsArray, letter);
        System.out.println("Frequency of words starting with '" + letter + "': " + frequency);
        
        // Get and print words starting with the letter (Problem 2)
        printWordsStartingWith(wordsArray, letter);
        
        console.close();
        in.close();
    }


    //Problem 1: Calculate the frequency of words starting with a specific letter.
    //Uses binary search to efficiently find the bounds of words starting with the letter.
    public static int calculateFrequency(String[] words, char letter) {
        // find the index of the first word starting with 'letter'
        int startIndex = findFirstOccurrence(words, letter);
        
        // If no word starts with the selected letter, we return 0
        if (startIndex == -1) {
            return 0;
        }
        
        // Now the code finds the index of the first word starting with the next letter
        char nextLetter = (char)(letter + 1);
        int endIndex = findFirstOccurrence(words, nextLetter);
        
        // If ther is no word with the next letter, endIndex is the length of the array
        if (endIndex == -1) {
            endIndex = words.length;
        }
        
        // The frequency is the difference between these two numbers
        return endIndex - startIndex;
    }

    //Modified binary search that finds the first occurrence of a word starting with the given letter in a sorted array.
    public static int findFirstOccurrence(String[] words, char letter) {
        int left = 0;
        int right = words.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If the word is empty or its first letter is less than our target value
            if (words[mid].isEmpty() || words[mid].charAt(0) < letter) {
                left = mid + 1;
            } 
            // If the first letter is a match for our target
            else if (words[mid].charAt(0) == letter) {
                result = mid; // Potential candidate
                right = mid - 1; // Look for earlier occurrences
            } 
            // If the first letter is greater than our target value
            else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    //Problem 2: Create an array containing all words that start with a specific letter.
    public static String[] getWordsStartingWith(String[] words, char letter) {
        // Calculates the frequency
        int frequency = calculateFrequency(words, letter);
        
        // This creates a new array of the appropriate size
        String[] result = new String[frequency];
        
        // Find the starting index
        int startIndex = findFirstOccurrence(words, letter);
        
        // If no words start with this letter, return an empty array
        if (startIndex == -1) {
            return result;
        }
        
        // Copy the words to the new array
        for (int i = 0; i < frequency; i++) {
            result[i] = words[startIndex + i];
        }
        
        return result;
    }

    //Prints all words starting with the given letter.
    public static String[] printWordsStartingWith(String[] words, char letter) {
        String[] wordsWithLetter = getWordsStartingWith(words, letter);
        System.out.println("Words starting with '" + letter + "' (" + wordsWithLetter.length + " words):");
        
        // Print all words if possible
        // If there are alot of words it just prints the first few
        int maxToPrint = Math.min(wordsWithLetter.length, 100); // Limit printing to 100 words
        for (int i = 0; i < maxToPrint; i++) {
            System.out.println(wordsWithLetter[i]);
        }
        
        if (wordsWithLetter.length > maxToPrint) {
            System.out.println("... and " + (wordsWithLetter.length - maxToPrint) + " more words");
        }
        
        return wordsWithLetter;
    }
}