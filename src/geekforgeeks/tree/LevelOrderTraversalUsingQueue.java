package geekforgeeks.tree;

import ds.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal Using Queue
 *
 * @author Akash Patra
 */
public class LevelOrderTraversalUsingQueue {

    //
    Node root;

    public LevelOrderTraversalUsingQueue() {
        root = null;
    }

    /**
     * Print Binary Tree
     *
     * @param root
     */
    public void printBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // Add the Child if not null
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
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

        LevelOrderTraversalUsingQueue traversalUsingQueue = new LevelOrderTraversalUsingQueue();
        traversalUsingQueue.printBinaryTree(root);
    }
}
