package algo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Reverse of {@link OptimalMergePattern}
 *
 * @author Akash Patra
 */
public class UnoptimalMergePattern {

    // Function to find minimum computation
    static int minComputation(int size, int files[]) {
        // create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(new DescComparator());

        for (int i = 0; i < size; i++) {
            // add sizes to priorityQueue
            pq.add(files[i]);
        }

        // Variable to count total Computations
        int count = 0;

        while (pq.size() > 1) {
            // pop two smallest size element
            // from the min heap
            int temp = pq.poll() + pq.poll();

            // add the current computations
            // with the previous one's
            count += temp;

            // add new combined file size
            // to priority queue or min heap
            pq.add(temp);
        }

        return count;
    }

    static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        // no of files
        int size = 6;

        // 6 files with their sizes
        int files[] = new int[]{2, 3, 4, 5, 6, 7};

        // total no of computations
        // do be done final answer
        System.out.println("Minimum Computations = "
                + minComputation(size, files));
    }
}
