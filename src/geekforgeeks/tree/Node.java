package geekforgeeks.tree;

/**
 * @author Akash Patra
 */
public class Node {
    int data;
    Node left, right;

    public Node(int item) {
        this.data = item;
        left = right = null;
    }
}
