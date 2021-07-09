package geekforgeeks.tree;

import ds.tree.Node;

/**
 * Sum of all nodes using Recursion
 *
 * @author Akash Patra
 */
public class SumOfAllNodesRecursion {

    //
    Node root;

    public SumOfAllNodesRecursion() {
        root = null;
    }

    public int findSum(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + findSum(root.left) + findSum(root.right);
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

        SumOfAllNodesRecursion sumOfAllNodesRecursion = new SumOfAllNodesRecursion();
        System.out.println(sumOfAllNodesRecursion.findSum(root));
    }
}
