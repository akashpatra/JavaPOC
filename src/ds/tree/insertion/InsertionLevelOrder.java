package ds.tree.insertion;

import ds.tree.Node;
import ds.tree.traversal.InorderTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>GeeksForGeeks</b> : Insert Node in a binary Tree in Level Order
 *
 * @author Akash Patra
 */
public class InsertionLevelOrder {

    static Node root;

    static void insert(Node temp, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void main (String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion:");
        // Inorder
        InorderTraversal traversal = new InorderTraversal();
        traversal.inorderRec(root);

        // insert
        insert(root, 12);

        System.out.print("\nInorder traversal after insertion:");
        // inorder
        traversal = new InorderTraversal();
        traversal.inorderRec(root);
    }
}
