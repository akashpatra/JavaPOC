package hackerrank.algo.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Akash Patra
 * @link https://www.hackerrank.com/challenges/jim-and-the-orders/problem
 */
public class JimAndOrders {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        int tOrder = orders.length;

        // Create a Customer Array to store the states
        Cust[] cArr = new Cust[tOrder];
        for (int i = 0; i < tOrder; i++) {
            cArr[i] = new Cust();
            cArr[i].seq = i + 1;
            cArr[i].oNo = orders[i][0];
            cArr[i].pTime = orders[i][1];
            // Delivery Time is calculated on OrderNo + Process Time.
            cArr[i].dTime = cArr[i].oNo + cArr[i].pTime;
        }

        // Sort the Customer Array in Ascending Order.
        Arrays.sort(cArr, (c1, c2) -> c1.dTime - c2.dTime);

        // Store the Sequences in an Array
        int[] temp = new int[tOrder];
        for (int i = 0; i < tOrder; i++) {
            temp[i] = cArr[i].seq;
        }
        return temp;
    }

    /**
     * Customer Class to store some information
     */
    static class Cust {
        int seq;
        int oNo;
        int pTime;
        int dTime;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
                System.out.print(" ");
            }
        }

//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
