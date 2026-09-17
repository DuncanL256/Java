// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."


import java.util.*;

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }


    //_____________________________Newly Implemented Methods begin here___________________________________

    // Method 1: Calculate the diameter of a binary tree
    // The diameter is  supposed to be the length of the longest path between any two nodes
    public int diameter() {
        return diameterHelper(overallRoot);
    }

    // Helper method for calculating the diameter
    private int diameterHelper(IntTreeNode root) {
        // Base case: if the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Calculate the diameter through the root 
        //Height of left subtree + height of right subtree
        int diameterThroughRoot = height(root.left) + height(root.right);
        
        // Calculate the diameter of left and right subtrees
        int leftDiameter = diameterHelper(root.left);
        int rightDiameter = diameterHelper(root.right);
        
        // This returns the maximum of the three given diameters
        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    // Helper method designed to to calculate the height of a tree
    private int height(IntTreeNode root) {
        // We start with an empty tree having height 0
        if (root == null) {
            return 0;
        }
        // Return the maximum height of left or right subtree, plus 1 for the current node
        return 1 + Math.max(height(root.left), height(root.right));
    }



    // Method 2: Check if two binary trees are identical
    public boolean isIdentical(IntTree other) {
        return isIdenticalHelper(this.overallRoot, other.overallRoot);
    }

    // Helper method for checking if two trees are identical
    private boolean isIdenticalHelper(IntTreeNode root1, IntTreeNode root2) {
        // If both trees are empty, they are considered identical
        if (root1 == null && root2 == null) {
            return true;
        }
        
        // If one tree is empty and the other is not, they are not identical
        if (root1 == null || root2 == null) {
            return false;
        }
        
        // Check if current nodes have the same value and their subtrees are identical
        return (root1.data == root2.data) && 
            isIdenticalHelper(root1.left, root2.left) && 
            isIdenticalHelper(root1.right, root2.right);
    }



    // Method 3: Count the number of nodes at a given level
    public int countNodesAtLevel(int level) {
        return countNodesAtLevelHelper(overallRoot, 0, level);
    }

    // Helper method for counting nodes at a given level
    private int countNodesAtLevelHelper(IntTreeNode root, int currentLevel, int targetLevel) {
        // In this base case the empty tree has no nodes
        if (root == null) {
            return 0;
        }
        
        // If we've reached the target level, count this node
        if (currentLevel == targetLevel) {
            return 1;
        }
        
        // Otherwise, recurse on left and right children at the next level
        return countNodesAtLevelHelper(root.left, currentLevel + 1, targetLevel) + 
            countNodesAtLevelHelper(root.right, currentLevel + 1, targetLevel);
    }



    // Method 4: Check if a binary tree is a proper binary tree
    public boolean isProper() {
        return isProperHelper(overallRoot);
    }

    // This is a helper method for checking if a tree is proper binary tree
    private boolean isProperHelper(IntTreeNode root) {
        //An empty tree is considered proper
        if (root == null) {
            return true;
        }
        
        // This checks if the current node has either 0 or 2 children
        boolean hasProperChildren = (root.left == null && root.right == null) || (root.left != null && root.right != null);
        
        // If current node lacks proper children, the tree is not counted as proper
        if (!hasProperChildren) {
            return false;
        }
        
        // If current node has proper children, we check its subtrees
        return isProperHelper(root.left) && isProperHelper(root.right);
    }
}