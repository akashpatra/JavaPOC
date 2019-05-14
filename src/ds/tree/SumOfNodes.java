package ds.tree;

/**
 * Binary Tree
 * ANy node can have at max 2 node (lefr + right)
 * <p>
 * I want to calculate sum of each node in a binary tree
 * <p>
 * Asked in HotStar
 *
 * @author Akash Patra
 */
public class SumOfNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int i) {
            this.data = i;
            left = right = null;
        }
    }

    public static void main() {
        // Create a BT with values

        //
        /*Queue q = new Queue();
        q.add(root);

        Node new;
        int sum = 0;
        while (q is not empty){
            current = q.pop();
            println("Node " + current.data + ":" + sumOfNode(current));
            q.add(current.left);
            q.add(current.right);
        }*/
    }

    private int sumOfNode(Node n) {
        /*Queue q = new Queue();
        q.add(n);

        Node new;
        int sum = 0;
        while (q is not empty){
            current = q.pop();
            sum += current.data;
            if (current.left != null {
                q.add(current.left);
            }

            q.add(current.right);
        }

        return sum;*/
        return 0;
    }
}
