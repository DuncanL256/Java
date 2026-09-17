// Short program that demonstrates the use of the IntTree class.

public class IntTreeClient {
    public static void main(String[] args) {
        IntTree t = new IntTree(12);
        System.out.println("Tree structure:");
        t.printSideways();
        System.out.println();
        t.printPreorder();
        t.printInorder();
        t.printPostorder();
        System.out.println("");

        //Method 1
        int methOne = t.diameter();
        System.out.println("Diameter of Binary Tree: " + methOne);

        //Method 2
        IntTree comparisonT = new IntTree(12); // should have identical structure to tree t
        boolean methTwo = t.isIdentical(comparisonT);

        System.out.println("");
        if(methTwo == true){
            System.out.println("Are the two binary trees identical? Yes");
        } else {
            System.out.println("Are the two binary trees identical? No");
        }
        //if else statement used to make terminal more presentable

        //Method 3
        // Count nodes at level 0 (just the root)
        int rootCount = t.countNodesAtLevel(0);  // Should return 1
        System.out.println("");
        System.out.println("Level 0 nodes: " + rootCount);

        // Count nodes at level 1 (children of the root)
        int level1Count = t.countNodesAtLevel(1);  // Should return 2 if both children exist
        System.out.println("Level 1 nodes: " + level1Count);

        // Counts level 2 nodes
        int level2Count = t.countNodesAtLevel(2);  // Could return up to 4 nodes depending on tree structure
        System.out.println("Level 2 nodes: " + level2Count);
        System.out.println("");



        //Method 4
        boolean methFour = t.isProper();
        if(methFour == false){
            System.out.println("Is this binary tree a propper binary tree? No.");
        } else{
            System.out.println("Is this binary tree a propper binary tree? Yes.");
        }
        //if else statement used to make terminal more presentable
        System.out.println(""); // I put a few spacers in the code to make the terminal look better as well
    }
}
