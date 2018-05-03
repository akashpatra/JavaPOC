package hackerrank.datastructures.linkedlist;

/**
 * @author Akash Patra
 */
public class Reverse {
    // Head of List
    public Node head;

    // Linked List Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Reverse lList = new Reverse();

        lList.head = new Node();
        lList.head.data = 1;
        Node second = new Node();
        second.data = 2;
        Node third = new Node();
        third.data = 3;

        lList.head.next = second;
        second.next = third;

        System.out.println("Original Linked List");
        lList.printNodes(lList);

        reverse(lList.head);
    }

    private void printNodes(Reverse lList) {
        Node n = lList.head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    private static void reverse(Node head) {
        if (null == head) {
            return;
        } else {
            reverse(head.next);
            System.out.println(head.data);
        }
    }
}
