package hackerrank.algo.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Akash Patra
 * @link https://www.hackerrank.com/challenges/greedy-florist/problem
 * @link Explanation: https://www.hackerrank.com/challenges/greedy-florist/forum/comments/765252?h_r=profile
 */
public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

        // Convert Array to List
        List<Integer> cList = new ArrayList<Integer>();
        for (int index = 0; index < c.length; index++) {
            cList.add(c[index]);
        }

        // Print before Sorting√
        System.out.println("Before Sorting:");
        for (Integer str : cList) {
            System.out.println(str);
        }
        // Sort in Descending order
        Collections.sort(cList, Collections.reverseOrder());

        // Print after Sorting
        System.out.println("After Sorting:");
        for (Integer str : cList) {
            System.out.println(str);
        }

        // Previous Flower Count
        int prev = -1;

        // Cost
        long cost = 0;


        int i = 0;
        for (Integer fCost : cList) {
            // Increase the Previous Flower Count, when each customer got a flower.
            if (i % k == 0) {
                ++prev;
            }
            cost += (fCost * (prev + 1));
            ++i;
        }

        return (int) cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
