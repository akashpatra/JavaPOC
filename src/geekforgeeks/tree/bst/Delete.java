package geekforgeeks.tree.bst;

import ds.tree.traversal.InorderTraversal;
import ds.tree.Node;

/**
 * Deleting Nodes using Recursion
 *
 * @author Akash Patra
 */
public class Delete {

    public Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // It means the key is equal to root data

            if (root.left == null) {
                // Case 1 & 2: Leaf Node and Single Child
                return root.right;
            } else if (root.right == null) {
                // Case 1 & 2: Leaf Node and Single Child
                return root.left;
            } else {
                // Case 3: Both Child are present

                // Find immediate successor or pre-decessor
                Node pre = findMin(root.right);
                // Copy the succ/pre value. Now, there will be two values of this in the tree.
                root.data = pre.data;
                // Delete the succ/pre, passing root.right as root. If we pass root,
                // then root will match with the value ad it gets deleted
                root.right = deleteRec(root.right, pre.data);
            }
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();

        int[] data = {15, 10, 20, 8, 12, 11, 25};

        Node root = new Node(data[0]);
        for (int i = 1; i < data.length; i++) {
            insert.insertRec(root, data[i]);
        }

        InorderTraversal traversal = new InorderTraversal();
        System.out.println("Initial Traversal");
        traversal.inorderRec(root);

        Delete delete = new Delete();

        // Delete 15
        Node newRoot = delete.deleteRec(root, 15);
        System.out.println("\nAfter deleting 15, Traversal is:");
        traversal.inorderRec(newRoot);

        // Delete 25
        newRoot = delete.deleteRec(root, 25);
        System.out.println("\nAfter deleting 25, Traversal is:");
        traversal.inorderRec(newRoot);
    }
}
