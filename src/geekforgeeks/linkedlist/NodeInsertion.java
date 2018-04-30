package geekforgeeks.linkedlist;

/**
 * @author Akash Patra
 */
public class NodeInsertion {
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
        NodeInsertion lList = new NodeInsertion();

        lList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        lList.head.next = second;
        second.next = third;

        System.out.println("Original Linked List");
        lList.printNodes(lList);

        // Insert Node at Start
        lList.insertNodeAtHead();
        System.out.println("After Insertion at start");
        lList.printNodes(lList);

        // Insert Node at Between
        lList.insertNodeAtBetween(null);
        System.out.println("After Insertion at between");
        lList.printNodes(lList);

        // Insert Node at End
        lList.insertNodeAtEnd();
        System.out.println("After Insertion at end");
        lList.printNodes(lList);
    }

    private void printNodes(NodeInsertion lList) {
        Node n = lList.head;
        while (null != n) {
            System.out.println("Node Value: " + n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    private void insertNodeAtHead() {
        Node newStartNode = new Node(0);
        newStartNode.next = head;
        head = newStartNode;
    }

    private void insertNodeAtBetween(Node prevNode) {
        if (null == prevNode) {
            System.out.println("Previous Node can't be empty");
            return;
        }

        Node newBtnNode = new Node(11);
        newBtnNode.next = prevNode.next;
        prevNode.next = newBtnNode;
    }

    private void insertNodeAtEnd() {
        Node newEndNode = new Node(-1);

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
