package poc;

import java.util.Arrays;

public class Permu {

	private static int a[] = {1,2,3,4};
	
	public static void main(String[] args) {
		permu(a,1,4);
	}
	
	private static void permu(int a[], int k, int n) {
		if (k == n) {
			System.out.println(Arrays.toString(a));
		} else {
			int t;
			for (int i = k-1; i < n; i++) {
				t = a[k-1];
				a[k-1] = a[i];
				a[i] = t;
				permu(a, k+1, n);
				t = a[k-1];
				a[k-1] = a[i];
				a[i] = t;
			}
		}
	}
}
