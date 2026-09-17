// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    // Start of the Delete Method __________________________________________________________________________
    public void delete(E value) {
        overallRoot = delete(overallRoot, value);
    }
    
    private SearchTreeNode<E> delete(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return null;
        }
        
        int compare = value.compareTo(root.data);
        
        if (compare < 0) {
            // Value is less than current node, go left
            root.left = delete(root.left, value);
        } else if (compare > 0) {
            // Value is greater than current node, go right
            root.right = delete(root.right, value);
        } else {
            // Found the node to delete
            
            // Case 1 - Node has no children
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // Case 2 - Node has only one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            
            // Case 3 - Node has two children
            // Find the inorder successor. It is the smallest node in right subtree
            root.data = findMin(root.right);
            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        
        return root;
    }
    
    // Helper method to find the minimum value in a subtree
    private E findMin(SearchTreeNode<E> root) {
        E minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    // End of the Delete Method _____________________________________________________________________________________

    // Start of Height Method _______________________________________________________________________________________
    public int height() {
        return height(overallRoot);
    }

    private int height(SearchTreeNode<E> root) {
        if (root == null) {
            return 0;
        }
        
        // Height is the maximum height of left or right subtree, plus 1 for current node
        return 1 + Math.max(height(root.left), height(root.right));
    }
    // End of Height Method _________________________________________________________________________________________

    // Start of IsAVL Method ________________________________________________________________________________________
    public boolean isAVL() {
        return isAVL(overallRoot);
    }
    
    private boolean isAVL(SearchTreeNode<E> root) {
        if (root == null) {
            return true;
        }
        
        // Check if current node is balanced
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int balanceFactor = Math.abs(leftHeight - rightHeight);
        
        // If balance factor is more than 1, the tree is not AVL
        if (balanceFactor > 1) {
            return false;
        }
        
        // Then recursively check if left and right subtrees are AVL
        return isAVL(root.left) && isAVL(root.right);
    }
}
