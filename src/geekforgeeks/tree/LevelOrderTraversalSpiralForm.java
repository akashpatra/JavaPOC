package geekforgeeks.tree;

/**
 * @author Akash Patra
 */
public class LevelOrderTraversalSpiralForm {
    Node root;

    public void printSpiral(Node node) {
        int height = height(node);
        boolean ltr = false;
        for (int i = 1; i <= height; i++) {
            printLevel(node, i, ltr);
            ltr = !ltr;
        }
    }

    private void printLevel(Node node, int level, boolean ltr) {
        if (level == 1) {
            System.out.print(node.data + " ");
        } else {
            if (ltr) {
                printLevel(node.left, level - 1, ltr);
                printLevel(node.right, level - 1, ltr);
            } else {
                printLevel(node.right, level - 1, ltr);
                printLevel(node.left, level - 1, ltr);
            }
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = height(node.left);
            int hHeight = height(node.right);

            if (lHeight > hHeight) {
                return lHeight + 1;
            } else {
                return hHeight + 1;
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversalSpiralForm spiral = new LevelOrderTraversalSpiralForm();
        spiral.root = new Node(1);
        spiral.root.left = new Node(2);
        spiral.root.right = new Node(3);

        spiral.root.right.right = new Node(4);
        spiral.root.right.left = new Node(5);
        spiral.root.left.right = new Node(6);
        spiral.root.left.left = new Node(7);

        spiral.printSpiral(spiral.root);
    }
}
