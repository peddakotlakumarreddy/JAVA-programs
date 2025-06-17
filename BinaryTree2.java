// BinaryTreeNode class represents each node in the tree
class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree2 {
    BinaryTreeNode root;

    // Method to mirror the tree (swap left and right subtrees)
    public void mirror(BinaryTreeNode node) {
        // If the node is null, there's nothing to mirror
        if (node == null)
            return;

        // Swap the left and right child
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively mirror the left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Wrapper method to mirror the tree from the root
    public void mirror() {
        mirror(root);
    }

    // Method to print the tree in-order (for visualization purposes)
    public void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        // Create a binary tree and add nodes to it
        BinaryTree2 tree = new BinaryTree2();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(6);

        System.out.println("Original Tree (In-order traversal):");
        tree.inOrderTraversal(tree.root);  // Original tree traversal
        System.out.println();

        // Mirror the tree
        tree.mirror();

        System.out.println("\nMirrored Tree (In-order traversal):");
        tree.inOrderTraversal(tree.root);  // Mirrored tree traversal
    }
}
