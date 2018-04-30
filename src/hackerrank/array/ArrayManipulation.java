package hackerrank.array;

import hackerrank.Logger;

import java.util.Scanner;

/**
 * The solution is to Diff Arr
 * https://www.hackerrank.com/challenges/crush/forum/comments/301792
  0   0   0   0   0 
  100  0  -100  0    0  <--- 1 2 100, 3rd col is 100 less than 2nd col 
  100  100 -100 0    0  <--- 2 5 100, 2nd col is 100 more than 1st col
  100  100  0  0  -100   <--- 3 4 100, now 3rd is equal to 2nd, and 5th is 100 less than 4th col
so finally, 1st col is always the real value, and others are accumlated of previous values and it self. 
so actual values are 100 200 200 200 100, max is 200
 * @author B0097634
 *
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// List Size
		int n = in.nextInt();
		if (n < 3 || n > 10000000) {
			return;
		}
		
		long[] mainArr = new long[n + 1]; 

		// No of Operations
		int m = in.nextInt();
		if (m < 1 || m > 200000) {
			return;
		}

		// Take input for operations
		int a, b, k;
		for (int i = 0; i < m; i++) {
			a = in.nextInt();
			b = in.nextInt();
			k = in.nextInt();

			// Check to avoid arrayIndexOfBound exception
			if ((a >= 1 && a <= n) && (b >= 1 && b <= n) && (k >= 0 && k <= 1000000000)) {
				// Operate on MainList
				mainArr[a-1] += k;
				mainArr[b] -= k;
			}
		}
		in.close();

		// Find the max value in List
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += mainArr[i];
			max = Math.max(max, sum);
		}

		System.out.println("Max is: " + max);
		Logger.log("Max is: " + max);
	}
}
