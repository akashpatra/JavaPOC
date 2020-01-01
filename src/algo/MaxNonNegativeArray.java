package corejava.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Akash Patra
 */
public class MaxNonNegativeArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int length = A.size();
        int s = -1, d = -1;
        boolean reset = false;
        List<Index> subArrList = new ArrayList();

        // Break into Sub-Arrays.
        for (int i = 0; i < length; i++) {
            if (A.get(i) < 0) {
                // To avoid, duplicate entries in SubArray List.
                if (!reset && s != -1 && d != -1) {
                    subArrList.add(new Index(s, d));
                }
                reset = true;
            } else {
                if (s == -1 || reset) {
                    reset = false;
                    s = i;
                }

                d = i;
            }
        }

        // If all Elements are non-negative
        if (s == 0 && d == length-1) {
            subArrList.add(new Index(s, d));
        }
//
//        // If last element is non-negative
//        if (s == length - 1 && d == length -1) {
//            subArrList.add(new Index(s, d));
//        }

        if (!reset && A.get(d) > 0) {
            subArrList.add(new Index(s, d));
        }

        // Traversing the Sub-Arrays
        length = subArrList.size();
        Index max1SubArray = null, max2SubArray = null, temp;
        int source = -1, dest = -1;
        long sum = 0, max1 = -1, max2 = -1;
        if (length == 1) {
            max1SubArray = subArrList.get(0);
        } else {
            for (int i = 0; i < length; i++) {
                temp = subArrList.get(i);
                sum = 0;

                source = temp.getS();
                dest = temp.getD();
                for (int k = source; k <= dest; k++) {
                    sum += A.get(k);
                }

                if (sum == max1) {
                    max2 = sum;
                    max2SubArray = temp;
                }

                if (sum > max1) {
                    max1 = sum;
                    max1SubArray = temp;
                }
            }
        }

        // Check the Conditions
        if (max1SubArray != null && max2SubArray != null) {
            if (max1 == max2) {
                int diff1 = max1SubArray.getD() - max1SubArray.getS() + 1;
                int diff2 = max2SubArray.getD() - max2SubArray.getS() + 1;

                if (diff1 < diff2) {
                    max1SubArray = max2SubArray;
                } else if (diff1 == diff2) {
                    int s1 = max1SubArray.getS();
                    int s2 = max2SubArray.getS();

                    if (s2 < s1) {
                        max1SubArray = max2SubArray;
                    }
                }
            }
        }

        ArrayList<Integer> chooseList = new ArrayList<>();
        if (max1SubArray != null) {
            for (int k = max1SubArray.getS(); k <= max1SubArray.getD(); k++) {
                chooseList.add(A.get(k));
            }
        }
        return chooseList;
    }

    class Index {
        int s;
        int d;

        Index(int s, int d) {
            this.s = s;
            this.d = d;
        }

        public Integer getS() {
            return s;
        }

        public Integer getD() {
            return d;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421));

        MaxNonNegativeArray obj = new MaxNonNegativeArray();
        System.out.println(obj.maxset(numbers));
    }
}
