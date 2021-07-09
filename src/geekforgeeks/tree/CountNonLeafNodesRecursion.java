package geekforgeeks.tree;

import ds.tree.Node;

/**
 * Total Non-Leaf nodes using Recursion
 *
 * @author Akash Patra
 */
public class CountNonLeafNodesRecursion {

    //
    Node root;

    public CountNonLeafNodesRecursion() {
        root = null;
    }

    public int findTotalNonLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        } else {
            return 1 + findTotalNonLeafNodes(root.left) + findTotalNonLeafNodes(root.right);
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
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.left = new Node(10);

        CountNonLeafNodesRecursion sumOfAllNodesRecursion = new CountNonLeafNodesRecursion();
        System.out.println(sumOfAllNodesRecursion.findTotalNonLeafNodes(root));
    }
}
