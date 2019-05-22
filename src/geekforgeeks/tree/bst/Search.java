package geekforgeeks.tree.bst;

import geekforgeeks.tree.Node;

/**
 * Search an element in BST
 *
 * @author Akash Patra
 */
public class Search {

    public boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        Node root = new Node(7);
        insert.insertRec(root, 5);
        insert.insertRec(root, 3);
        insert.insertRec(root, 4);
        insert.insertRec(root, 1);
        insert.insertRec(root, 8);
        insert.insertRec(root, 9);

        Search search = new Search();
        System.out.println("Search Result: " + search.searchRec(root, 1));
    }
}
