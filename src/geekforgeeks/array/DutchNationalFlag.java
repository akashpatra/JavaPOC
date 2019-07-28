package geekforgeeks.array;

/**
 * Sorting of 0's, 1's, 2's etc using DutchNationalFlag Algorithm
 *
 * @author Akash Patra
 * @link https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arrSize = arr.length;
        System.out.println("Array before segregation 012 ");
        printArray(arr, arrSize);
        sort012(arr, arrSize);
        System.out.println("Array after segregation 012 ");
        printArray(arr, arrSize);

        int arr_1[] = {0, 1, 1, 3, 0, 1, 2, 1, 3, 2, 0, 0, 0, 1};
//        int arr_1[] = {0, 1, 1, 2, 0, 3, 2, 1, 3, 3, 0, 0, 0, 1};
        int arr_size_1 = arr_1.length;
        sort0123(arr_1, arr_size_1);
        System.out.println();
        System.out.println("Array after segregation 0123 ");
        printArray(arr_1, arr_size_1);
    }

    private static void printArray(int[] arr, int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorting of 0's, 1's and 2's
     *
     * @param arr
     * @param arrSize
     */
    private static void sort012(int[] arr, int arrSize) {
        int lo = 0, mid = 0, temp;
        int hi = arrSize - 1;

        while (mid <= hi) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                    break;
            }
        }
    }

    /**
     * Sorting of 0's, 1's, 2's & 3's
     *
     * @param arr
     * @param arr_size
     */
    private static void sort0123(int[] arr, int arr_size) {
        int lo = 0, mid1 = 0, temp;
        int mid2 = 0, hi = arr_size - 1;

        while (mid2 <= hi) {
            switch (arr[mid2]) {
                case 0:
                    temp = arr[lo];
                    arr[lo] = arr[mid2];
                    arr[mid2] = temp;
                    lo++;
                    if (mid1 == 0 || (mid2 > 0 && arr[mid2] > arr[mid2 - 1])) {
                        mid1++;
                        mid2++;
                    }
                    break;
                case 1:
                    temp = arr[mid1];
                    arr[mid1] = arr[mid2];
                    arr[mid2] = temp;
                    mid1++;
                    mid2++;
                    break;
                case 2:
                    mid2++;
                    break;
                case 3:
                    temp = arr[hi];
                    arr[hi] = arr[mid2];
                    arr[mid2] = temp;
                    hi--;
                    break;
            }
            System.out.print("lo: " + lo + ", mid1: " + mid1 + ", mid2: " + mid2 + " -> ");
            printArray(arr, arr_size);
        }
    }

    /*private static void sort0123(int[] arr, int arr_size) {
        int lo = 0, mid1 = 0, temp;
        int mid2 = arr_size - 1, hi = arr_size - 1;

        while (mid1 <= hi && mid1 <= mid2) {
            switch (arr[mid1]) {
                case 0:
                    temp = arr[lo];
                    arr[lo] = arr[mid1];
                    arr[mid1] = temp;
                    lo++;
                    mid1++;
                    break;
                case 1:
                    mid1++;
                    break;
                case 2:
                    temp = arr[mid2];
                    arr[mid2] = arr[mid1];
                    arr[mid1] = temp;
                    mid2--;
                    break;
                case 3:
                    temp = arr[hi];
                    arr[hi] = arr[mid1];
                    arr[mid1] = temp;
                    mid2--;
                    hi--;
                    break;
            }
            System.out.print("mid1: " + mid1 + ", mid2: " + mid2 + "->");
            printArray(arr, arr_size);
        }
    }*/
}
