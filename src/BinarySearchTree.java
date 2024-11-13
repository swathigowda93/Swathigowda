public class BinarySearchTree {
    // Node class to represent each node in the tree
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value
    private Node insertRec(Node root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // return the (unchanged) node pointer
        return root;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function to search for a value
    private boolean searchRec(Node root, int value) {
        // Base case: root is null or value is present at the root
        if (root == null) {
            return false;
        }

        // Value is present at the root
        if (value == root.value) {
            return true;
        }

        // Value is greater than the root's value
        if (value > root.value) {
            return searchRec(root.right, value);
        }

        // Value is smaller than the root's value
        return searchRec(root.left, value);
    }

    // In-order traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    // Recursive function for in-order traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive function to delete a value
    private Node deleteRec(Node root, int value) {
        // Base case: the root is null
        if (root == null) {
            return root;
        }

        // If the value to be deleted is smaller than the root's value
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        }
        // If the value to be deleted is larger than the root's value
        else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        }
        // Value is equal to root's value
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Get the minimum value node
    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // Main function to test the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal of the BST:");
        bst.inorder(); // Output: 20 30 40 50 60 70 80
        System.out.println();

        // Search for a value
        System.out.println("Search for 40: " + bst.search(40)); // true
        System.out.println("Search for 100: " + bst.search(100)); // false

        // Delete a value
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inorder(); // Output: 30 40 50 60 70 80
        System.out.println();

        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inorder(); // Output: 40 50 60 70 80
    }
}


