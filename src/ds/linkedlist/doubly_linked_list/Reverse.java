package data_structures.linkedlist.doubly_linked_list;

/**
 * Reverse Double Linked List
 * Companies: Adobe
 *
 * @author Akash Patra
 */
public class Reverse {
    // Head of List
    Node head;

    // Node for DLL
    static class Node {
        int data;
        Node prev, next;

        Node(int i) {
            this.data = i;
        }
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.push(3);
        reverse.push(2);
        reverse.push(1);

        //
        System.out.println("*** Original ***");
        reverse.printNodes();

        //
        reverse.reverse();

        //
        System.out.println("*** After Reverse ***");
        reverse.printNodes();
    }

    private void push(int newData) {
        Node newNode = new Node(newData);

        newNode.prev = null;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    /**
     * Traverse
     */
    private void printNodes() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    /**
     * My Way
     */
    private void reverse() {
        Node n = head;
        Node prev, next;

        while (n != null) {
            prev = n.prev;
            next = n.next;
            n.prev = next;
            n.next = prev;
            if (next == null) {
                head = n;
            }
            n = next;
        }
    }

    /**
     * Got from GFG
     */
    private void reverse2() {
        Node n = head;
        Node temp = null;
        while (n != null) {
            temp = n.prev;
            n.prev = n.next;
            n.next = temp;
            n = n.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}
