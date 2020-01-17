package ds.heap;

/**
 * Sorting using Max Heap.
 * <p>
 * Two steps:
 * 1. Create a Max Heap using Heapify.
 * Time Complexity: O(n)
 * <p>
 * 2. Delete the root and place at the end of the array.
 * Time Complexity: n * O(logn) = O(nlogn)
 * <p>
 * Total Time Complexity: O(n + nlogn)
 *
 * @author Akash Patra
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    private void sort(int arr[]) {
        int n = arr.length;

        // Build Heap (Re-Arrange Array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract root to move to end
        for (int i = n - 1; i >= 0; i--) {
            // Move root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call Max Heapify on the new heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Check from leaves and check if the tree from that node is max heap or not.
     * Its root -> leaf.
     *
     * @param arr
     * @param n
     * @param i
     */
    private void heapify(int arr[], int n, int i) {
        // Set the current as largest
        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        // Check Left Child
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // Check Right Child
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // Swap the elements, if largest is not equal to i
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
