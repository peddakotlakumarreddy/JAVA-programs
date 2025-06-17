import java.util.Scanner;

// BinaryTreeNode class represents each node in the tree
class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree1 {
    BinaryTreeNode root;

    // Method to search for a given element in the binary tree
    public boolean search(BinaryTreeNode node, int key) {
        // If the node is null, return false (element not found)
        if (node == null)
            return false;

        // If the current node's data matches the key, return true
        if (node.data == key)
            return true;

        // Otherwise, search the left and right subtrees
        return search(node.left, key) || search(node.right, key);
    }

    // Wrapper method to search for an element from the root
    public boolean search(int key) {
        return search(root, key);
    }

    public static void main(String[] args) {
        // Create a binary tree and add nodes to it
        BinaryTree1 tree = new BinaryTree1();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(6);

        // Create Scanner object to read input from user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a number to search
        System.out.println("Enter a number to search in the binary tree: ");
        int key = scanner.nextInt();

        // Search for the element
        boolean result = tree.search(key);

        // Print the result
        if (result) {
            System.out.println("Element " + key + " is found in the tree.");
        } else {
            System.out.println("Element " + key + " is not found in the tree.");
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
