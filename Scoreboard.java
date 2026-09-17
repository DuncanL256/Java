import java.util.*;

/** Class for storing high scores in an array in nondecreasing order. */
public class Scoreboard {
    private int numEntries = 0; // number of actual entries
    private GameEntry[] board; // array of game entries (names & scores)
/** Constructs an empty scoreboard with the given capacity for storing entries.
*/
public Scoreboard(int capacity) {
    board = new GameEntry[capacity];
}

/** 
* Add a new entry in O(1) time.
* If board is not full, add at the end.
* If board is full, replace the last entry.
*/
public void add(GameEntry e) {
    if (numEntries < board.length) {
        // Add to the end if there's free space
        board[numEntries] = e;
        numEntries++;
    } else {
        // Replace the last entry if board is full
        board[board.length - 1] = e;
    }
}

/** Remove and return the high score at index i. */

/** 
* Remove and return entry at index i in the specified O(1) time.
* Move the last entry to position i to maintain connected entries.
*/
public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries) {
        throw new IndexOutOfBoundsException("Invalid index: " + i);
    }
    GameEntry temp = board[i];                    // Save the object to return
    board[i] = board[numEntries - 1];            // Move last entry to i
    board[numEntries - 1] = null;                // Clear the last position
    numEntries--;                                // One less entry
    return temp;
}

/** Returns a string representation of the high scores list. */
public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int j = 0; j < numEntries; j++) {
        if (j > 0)
            sb.append(", "); // separate entries by commas
        sb.append(board[j]);
    }
    sb.append("]");
    return sb.toString();
}

public GameEntry removeName(String name) throws IllegalArgumentException {
    // Find the entry with given name
    int i = -1;
    for (int j = 0; j < numEntries; j++) {
        if (board[j].getName().equals(name)) {
            i = j;
            break;
        }
    }
    
    if (i == -1) 
        throw new IllegalArgumentException("Name not found: " + name);
        
    GameEntry temp = board[i];
    // Shift entries left to fill the gap
    for (int j = i; j < numEntries - 1; j++) 
        board[j] = board[j+1];
        
    board[numEntries - 1] = null;
    numEntries--;
    return temp;
}

public static void main(String[] args) {
    // The main method
    Scoreboard highscores = new Scoreboard(5);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul",
    "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};
    for (int i=0; i < names.length; i++) {
        GameEntry gE = new GameEntry(names[i], scores[i]);
        System.out.println("Adding " + gE);
        highscores.add(gE);
        System.out.println(" Scoreboard: " + highscores);
    }
    System.out.println("Removing score at index " + 3);
    highscores.remove(3);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 1);
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 1);
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);
    }
}

