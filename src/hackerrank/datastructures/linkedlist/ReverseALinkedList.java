package hackerrank.datastructures.linkedlist;

/**
 * @author Akash Patra
 */
public class ReverseALinkedList {
    // Head of List
    Node head;

    // Linked List Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        ReverseALinkedList lList = new ReverseALinkedList();

        lList.head = new Node();
        lList.head.data = 1;
        Node second = new Node();
        second.data = 2;
        Node third = new Node();
        third.data = 3;

        lList.head.next = second;
        second.next = third;

        System.out.println("Original Linked List");
        lList.printNodes(lList.head);

        Node head = reverse(lList.head, null);

        System.out.println("After Reverse Linked List");
        lList.printNodes(head);
    }

    private void printNodes(Node n) {
//        Node n = lList.head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    private static Node reverse(Node current, Node prev) {
        if (null == current.next) {
//            head = current;
            current.next = prev;
            return current;
        }

        Node tempNext = current.next;
        current.next = prev;

        return reverse(tempNext, current);
//        System.out.println("Current: " + current.data + ", Prev: " + prev.data);
    }
}
