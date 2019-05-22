package geekforgeeks.tree.bst;

import geekforgeeks.tree.InorderTraversal;
import geekforgeeks.tree.Node;

/**
 * Insertion into BST, using RECURSION
 *
 * @author Akash Patra
 */
public class Insert {

    public Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        Node root = new Node(17);
        insert.insertRec(root, 5);
        insert.insertRec(root, 3);
        insert.insertRec(root, 4);
        insert.insertRec(root, 1);
        insert.insertRec(root, 8);
        insert.insertRec(root, 9);

        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.inorderRec(root);
    }
}
