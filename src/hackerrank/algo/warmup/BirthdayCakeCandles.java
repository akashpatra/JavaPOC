package hackerrank.algo.warmup;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Akash Patra
 */
public class BirthdayCakeCandles {
    /*
     * Complete the birthdayCakeCandles function below.
     */
    static int birthdayCakeCandles(int n, int[] ar) {
        /*
         * Write your code here.
         */
        int highCount = 0;
        int highestHeight = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > highestHeight) {
                highestHeight = ar[i];
                highCount = 0;
                ++highCount;
            } else if (ar[i] == highestHeight) {
                ++highCount;
            }
        }
        return highCount;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] ar = new int[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = birthdayCakeCandles(n, ar);
        System.out.println("Result: " + result);

//        bw.write(String.valueOf(result));
//        bw.newLine();
//
//        bw.close();
    }
}
