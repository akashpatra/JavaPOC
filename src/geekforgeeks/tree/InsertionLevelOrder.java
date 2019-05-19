package geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>GeeksForGeeks</b> : Insert Node in a binary Tree in Level Order
 *
 * @author Akash Patra
 */
public class InsertionLevelOrder {

    static class Node {
        int key;
        Node left, right;

        // Constructor
        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree */
    static void inorder(Node temp) {

        if (temp == null) {
            return;
        }

        inorder(temp.left);
        System.out.println(temp.key + " ");
        inorder(temp.right);
    }

    static void insert(Node temp, int key) {
        Queue<Node> q = new LinkedList<>();
    }
}
