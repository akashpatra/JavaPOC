package geekforgeeks.tree;

/**
 * @author Akash Patra
 */
public class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        this.data = item;
        left = right = null;
    }
}
