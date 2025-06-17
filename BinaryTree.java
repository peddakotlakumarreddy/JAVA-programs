// BinaryTreeNode class represents each node in the tree
class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    BinaryTreeNode root;

    // Method to count non-leaf nodes in the tree
    public int countNonLeafNodes(BinaryTreeNode node) {
        // If the node is null, return 0
        if (node == null)
            return 0;

        // If it's a leaf node (no children), return 0
        if (node.left == null && node.right == null)
            return 0;

        // Otherwise, count the current node + non-leaf nodes in both left and right subtrees
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    // Method to count leaf nodes in the tree
    public int countLeafNodes(BinaryTreeNode node) {
        // If the node is null, return 0
        if (node == null)
            return 0;

        // If it's a leaf node (both left and right children are null), return 1
        if (node.left == null && node.right == null)
            return 1;

        // Otherwise, count leaf nodes in both left and right subtrees
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // Wrapper method to count non-leaf nodes from the root
    public int countNonLeafNodes() {
        return countNonLeafNodes(root);
    }

    // Wrapper method to count leaf nodes from the root
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    public static void main(String[] args) {
        // Create a binary tree and add nodes to it
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(6);

        // Count non-leaf nodes
        int nonLeafNodeCount = tree.countNonLeafNodes();
        // Count leaf nodes
        int leafNodeCount = tree.countLeafNodes();

        // Print the results
        System.out.println("Number of Leaf Nodes: " + leafNodeCount);
        System.out.println("Number of Non-Leaf Nodes: " + nonLeafNodeCount);
    }
}
