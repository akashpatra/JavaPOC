package ds.tree.traversal;

import ds.tree.Node;

/**
 * Inorder Traversal of a Tree, using RECURSION
 *
 * @author Akash Patra
 */
public class InorderTraversal {

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        InorderTraversal traversal = new InorderTraversal();
        traversal.inorderRec(root);
    }
}
