package ds.linkedlist;

/**
 * Node Deletion at Position
 *
 * @author Akash Patra
 */
public class NodeDeletionAtPostn {
    // Head of Linked List
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        NodeDeletionAtPostn lList = new NodeDeletionAtPostn();
        lList.initializeNodes();

        System.out.println();
        System.out.println("Org:");
        lList.printNodes();

        lList.deleteNode(1);

        System.out.println("\n");
        System.out.println("After Deletion: ");
        lList.printNodes();

        System.out.println();
    }

    private void initializeNodes() {
        Node firstNode = new Node(8);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(1);
        Node fifthNode = new Node(7);

        head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
    }

    private void deleteNode(int postn) {
        int count = 0;

        Node n = head;
        if (postn == 0) {
            head = head.next;
            return;
        }

        while (null != n) {
            // Next one is the reqd postn
            if (count + 1 == postn) {
                n.next = n.next.next;
            }
            ++count;
            n = n.next;
        }
    }

    private void printNodes() {
        Node n = head;

        while (null != n) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
    }
}
