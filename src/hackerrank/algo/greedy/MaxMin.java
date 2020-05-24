package hackerrank.algo.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Akash Patra
 * @link https://www.hackerrank.com/challenges/angry-children/problem
 */
public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] c) {
        // Before Sorting
        System.out.println("Before Sorting:");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        // Sorting
        Arrays.sort(c);

        // After Sorting
        System.out.println("After Sorting:");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        // States
        int unfairness = 1000000000;
        int min, max;
        int len = c.length;

        // In Loop, checking unfairness. Bcz, there can be duplicate values.
        for (int i = 0; i < len - k + 1; i++) {
            min = c[i];
            max = c[i + k - 1];
            if ((max - min) < unfairness)
                unfairness = max - min;
        }
        return unfairness;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);
        System.out.println();
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
