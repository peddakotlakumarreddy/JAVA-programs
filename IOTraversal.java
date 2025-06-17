// Define a Node class for the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Main class containing inorder traversal logic
public class IOTraversal{
    Node root;

    // Inorder traversal: Left -> Root -> Right
    void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inorderTraversal(node.left);

        // Visit the root
        System.out.print(node.data + " ");

        // Traverse right subtree
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        IOTraversal tree = new IOTraversal();

        // Creating a sample tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of binary tree is:");
        tree.inorderTraversal(tree.root);
    }
}
