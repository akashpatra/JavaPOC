package ds.heap;

/**
 * Max Heap
 * <p>
 * FROM: GeeksForGeeks
 * <p>
 * Taking size of the array extra one and ignoring the 0th Element.
 * Easy to work on the logic's.
 * <p>
 * 1. Insert: Add element to the array and then check if it is larger than its parent. Then swap till all the parents
 * are greater than the child.
 * Time Complexity: n * O(logn) = O(nlogn)
 * <p>
 * 2. Remove Max Element: Place the last element as Root and heapify from root till all the parent are greater than
 * the child.
 * Time Complexity: n * O(logn) = O(nlogn)
 * <p>
 * Total Time Complexity: O(2nlogn) ~ O(nlogn)
 *
 * @author Akash Patra
 */
public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int left(int position) {
        return position * 2;
    }

    private int right(int position) {
        return (position * 2) + 1;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public void insert(int element) {
        heap[++size] = element;

        // Traverse upwards and fix violated property
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void heapify(int position) {
        while (heap[position] < heap[left(position)] ||
                heap[position] < heap[right(position)]) {

            if (heap[position] < heap[left(position)]) {
                swap(position, left(position));
                position = left(position);
            } else {
                swap(position, right(position));
                position = right(position);
            }
        }
    }

    private int maxElement() {
        int max = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return max;
    }

    private void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("Parent is " + heap[i] +
                    " -> Left: " + heap[left(i)] + ", Right: " + heap[right(i)]);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);

        maxHeap.insert(4);
//        maxHeap.print();
        maxHeap.insert(9);
//        maxHeap.print();
        maxHeap.insert(3);
//        maxHeap.print();
        maxHeap.insert(12);
        maxHeap.print();
    }
}