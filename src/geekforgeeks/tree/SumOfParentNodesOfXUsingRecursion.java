package geekforgeeks.tree;

/**
 * Sum of Parent Nodes of Element X using Recursion
 *
 * @author Akash Patra
 */
public class SumOfParentNodesOfXUsingRecursion {

    //
    Node root;

    //
    int sum;

    public SumOfParentNodesOfXUsingRecursion() {
        root = null;
    }

    public boolean findSum(Node root, int x) {
        if (root == null) {
            return false;
        }

        if (findSum(root.left, x)) {
            sum += root.data;
        }
        if (findSum(root.right, x)) {
            sum += root.data;
        }
        if (root.data == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(7);

        SumOfParentNodesOfXUsingRecursion sumOfParentNodesOfXUsingRecursion = new SumOfParentNodesOfXUsingRecursion();
        sumOfParentNodesOfXUsingRecursion.findSum(root, 2);
        System.out.println("Sum: " + sumOfParentNodesOfXUsingRecursion.sum);
    }
}
