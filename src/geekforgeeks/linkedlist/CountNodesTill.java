package geekforgeeks.linkedlist;

/**
 * <b>Problem Statement:</b>
 * <p>
 * Think the first element of Array as head of Linked List. Then, the value of that, is the index of next array
 * for next node of Linked List, till the value is -1 (which is tail of Linked List)
 * </p>
 *
 * @author Akash Patra
 */
public class CountNodesTill {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, -1, 2};
        System.out.println("NoOfNodes: " + solution(a));
    }

    public static int solution(int[] a) {
        int noOfNodes = 1;

        int i = 0;
        while (a[i] != -1) {
            ++noOfNodes;
            i = a[i];
        }

        return noOfNodes;
    }
}
