package algo;

import java.util.PriorityQueue;

/**
 * When two or more sorted files are to be merged all together to form a single file, the minimum computations
 * done to reach this file are known as Optimal Merge Pattern.
 * <p>
 * FROM: GeeksForGeeks
 *
 * @author Akash Patra
 */
public class OptimalMergePattern {

    // Function to find minimum computation
    static int minComputation(int size, int files[]) {
        // create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

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
