package geekforgeeks.tree;

/**
 * Level Order Traversal Using Recursion
 *
 * @author Akash Patra
 */
public class LevelOrderTraversalUsingRecursion {

    //
    Node root;

    public LevelOrderTraversalUsingRecursion() {
        root = null;
    }

    /**
     * Find height of a Tree
     *
     * @param root
     * @return
     */
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);
            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    /**
     * Print data at that level
     *
     * @param root
     * @param level
     */
    public void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.println(root.data);
        } else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public void printBinaryTree(Node root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
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

        LevelOrderTraversalUsingRecursion traversalUsingRecursion = new LevelOrderTraversalUsingRecursion();
        traversalUsingRecursion.printBinaryTree(root);
    }
}
