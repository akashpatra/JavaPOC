package geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal LineByLine Using Queue
 *
 * @author Akash Patra
 */
public class LevelOrderTraversalLineByLineUsingQueue {

    //
    Node root;

    public LevelOrderTraversalLineByLineUsingQueue() {
        root = null;
    }

    public void printBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();

            if (tempNode != null) {
                System.out.print(tempNode.data + " ");

                // Add the Child if not null
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            } else {
                System.out.println("");

                // Check next level is present or not
                if (queue.peek() != null) {
                    // Denote this level is completed
                    queue.add(null);
                }
            }
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

        LevelOrderTraversalLineByLineUsingQueue traversalUsingQueue = new LevelOrderTraversalLineByLineUsingQueue();
        traversalUsingQueue.printBinaryTree(root);
    }
}
