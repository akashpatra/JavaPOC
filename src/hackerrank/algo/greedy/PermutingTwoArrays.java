package hackerrank.algo.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Akash Patra
 * <p>
 * Problem:
 * @link https://www.hackerrank.com/challenges/two-arrays/problem
 */
public class PermutingTwoArrays {

    /**
     * Little complicated to understand and not optimized.
     * <p>
     * A[i] + B[i] >= K
     * => A[i] - K = -B[i]
     * So, the difference I am storing in another array as diff[]. [Space Complexity increased]
     * Then, I am sorting diff[] and also the B[].
     * Comparing the smallest in diff[] to the largest in B[]. [Bcz, -9 >= -(9)]
     *
     * @param k
     * @param A
     * @param B
     * @return
     */
    static String solution1(int k, int[] A, int[] B) {
        int len = B.length;
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = A[i] - k;
        }

        // Sorting the arrays
        Arrays.sort(diff);
        Arrays.sort(B);

        // Comparing the smallest in diff[] to the largest in B[]
        for (int i = 0; i < len; i++) {
            if (diff[i] < -B[len - 1 - i]) {
                return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            String result = solution1(k, A, B);
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
