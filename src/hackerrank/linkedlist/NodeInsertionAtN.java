package hackerrank.linkedlist;

/**
 * @author Akash Patra
 */
public class NodeInsertionAtN {
    // Head of List
    public Node head;

    // Linked List Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        NodeInsertionAtN lList = new NodeInsertionAtN();

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

        // Insert Node at Start
//        lList.insertNodeAtHead();
//        System.out.println("After Insertion at start");
//        lList.printNodes(lList);

        // Insert Node at Between
        lList.insertNodeAtN(lList.head, 123, 3);
        System.out.println("After Insertion at between");
        lList.printNodes(lList);

        // Insert Node at End
//        lList.insertNodeAtEnd();
//        System.out.println("After Insertion at end");
//        lList.printNodes(lList);
    }

    private void printNodes(NodeInsertionAtN lList) {
        Node n = lList.head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    private void insertNodeAtHead() {
        Node newStartNode = new Node();
        newStartNode.next = head;
        head = newStartNode;
    }

    private Node insertNodeAtN(Node head, int data, int position) {
        Node nNode = new Node();
        nNode.data = data;
        int i = 0;

        // Check for 0 Position
        if (i == position) {
            if (null == head) {
                head = nNode;
                return head;
            } else {
                nNode.next = head;
                head = nNode;
                return head;
            }
        }

        i = 1;
        Node n = head;
        while (null != n.next) {
            if (i == position) {
                nNode.next = n.next;
                n.next = nNode;
                return head;
            }
            i++;
            n = n.next;
        }

        // Check for last position
        if (i == position) {
            n.next = nNode;
        }

        return head;
    }

    private void insertNodeAtEnd() {
        Node newEndNode = new Node();
        newEndNode.data = -1;

        Node n = head;

        if (null == n) {
            head = newEndNode;
            return;
        }

        while (null != n.next) {
            n = n.next;
        }
        n.next = newEndNode;
    }
}
