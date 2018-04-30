package hackerrank.linkedlist;

/**
 * @author Akash Patra
 */
public class NodeDeletionAtN {
    // Head of List
    public Node head;

    // Linked List Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        NodeDeletionAtN lList = new NodeDeletionAtN();

        lList.head = new Node();
        lList.head.data = 0;
        Node second = new Node();
        second.data = 1;
        Node third = new Node();
        third.data = 2;

        lList.head.next = second;
        second.next = third;

        System.out.println("Original Linked List");
        lList.printNodes(lList.head);

        // Insert Node at Between
        Node head = lList.deleteNodeAtN(lList.head, 0);
        System.out.println("After Deletion at N");
        lList.printNodes(head);
    }

    private void printNodes(Node head) {
        Node n = head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    private Node deleteNodeAtN(Node head, int position) {
        int i = 0;

        Node prevNode = null;
        Node n = head;

        while (null != n.next) {
            if (i == position) {
                if (null == prevNode) {
                    // This is first element
                    head = n.next;
                } else {
                    // Other elements
                    prevNode.next = n.next;
                }
                n.next = null;
                return head;
            }
            // This is PrevNode
            prevNode = n;
            i++;
            n = n.next;
        }

        // Check for last element deletion
        if (i == position) {
            if (null == prevNode) {
                head = null;
            } else {
                prevNode.next = null;
            }
        }

        return head;
    }
}
