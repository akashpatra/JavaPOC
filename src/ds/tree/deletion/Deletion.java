package ds.tree.deletion;

import ds.tree.Node;
import ds.tree.traversal.InorderTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>GeeksForGeeks</b> : Delete a node from Binary Tree by making sure that tree shrinks from the bottom (i.e. the
 * deleted node is replaced by the bottom-most and rightmost node)
 *
 * @author Akash Patra
 */
public class Deletion {

    public static Node deletionBT(Node root, int key) {
        // Write your code here and return the root of the changed tree
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;
        Node keyNode = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        if (keyNode != null) {
            int x = temp.data;
            deleteDeepestNode(root, temp);
            keyNode.data = x;
        }
        return root;
    }

    private static void deleteDeepestNode(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    static Node root;

    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before deletion:");
        // Inorder
        InorderTraversal traversal = new InorderTraversal();
        traversal.inorderRec(root);

        int key = 11;
        deletionBT(root, key);

        System.out.print("\nInorder traversal after deletion:");
        traversal.inorderRec(root);
    }
}
