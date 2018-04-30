package geekforgeeks.linkedlist;

/**
 * @author Akash Patra
 */
public class LinkedList {
    // Head of List
    public Node head;

    // Linked List Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList lList = new LinkedList();

        lList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        lList.head.next = second;
        second.next = third;

        Node n = lList.head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
    }
}
