package hackerrank.algo.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Akash Patra
 * @link https://www.hackerrank.com/challenges/board-cutting/problem
 * <p>
 * Explanation: As, we need to minimum cost.
 * And, each cost is multiplied with number of segments.
 * So, first finish the costly cuts from y or x side.
 */
public class CuttingBoards {

    // TIP: Just change all the int to long, otherwise many test cases will fail

    // Complete the boardCutting function below.
    static long boardCutting(long[] cost_y, long[] cost_x) {

        // Sort both Arrays
        Arrays.sort(cost_y);
        Arrays.sort(cost_x);

        // Find the lengths
        int yLen = cost_y.length;
        int xLen = cost_x.length;

        // Number of Cuts
        int yCuts = 0, xCuts = 0;

        int j = yLen - 1;
        int i = xLen - 1;
        long cost = 0;
        long temp = 0;

        // Compare the price and start from costly costs
        while (j >= 0 && i >= 0) {
            if (cost_y[j] > cost_x[i]) {
                yCuts++;
                // Cuts + 1 ?? Because, after you cut a board it will be divided into two segments.
                temp = cost_y[j--] * (xCuts + 1);
            } else if (cost_x[i] > cost_y[j]) {
                xCuts++;
                temp = cost_x[i--] * (yCuts + 1);
            } else {
                yCuts++;
                temp = cost_y[j--] * (xCuts + 1);
            }

            cost += temp;
        }

        // Remaining cuts in Y Side.
        while (j >= 0) {
            yCuts++;
            temp = cost_y[j--] * (xCuts + 1);
            cost += temp;
        }

        // Remaining cuts in X Side.
        while (i >= 0) {
            xCuts++;
            temp = cost_x[i--] * (yCuts + 1);
            cost += temp;
        }

        return cost % 1000000007;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            long[] cost_y = new long[m - 1];

            String[] cost_yItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m - 1; i++) {
                long cost_yItem = Integer.parseInt(cost_yItems[i]);
                cost_y[i] = cost_yItem;
            }

            long[] cost_x = new long[n - 1];

            String[] cost_xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n - 1; i++) {
                long cost_xItem = Integer.parseInt(cost_xItems[i]);
                cost_x[i] = cost_xItem;
            }

            long result = boardCutting(cost_y, cost_x);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
