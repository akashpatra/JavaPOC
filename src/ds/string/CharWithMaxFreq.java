package ds.string;

import java.util.HashMap;

/**
 * @author Akash Patra
 */
public class CharWithMaxFreq {

    public static void main(String[] args) {
        String tempData = "cnn";
//        charWithMaxFreq(tempData);
        charWithMax2(tempData);
    }

    private static void charWithMaxFreq(String tempData) {
        HashMap<String, Integer> report = new HashMap<>();

        Integer temp;
        String data;
        for (int i = 0; i < tempData.length(); i++) {

            data = String.valueOf(tempData.charAt(i));
            temp = report.get(data);
            if (null == temp) {
                report.put(data, 1);
            }
        }
    }

    private static void charWithMax2(String tempData) {
        int[] intArr = new int[256];
        for (int i = 0; i < tempData.length(); i++) {
            intArr[tempData.charAt(i)]++;
        }

        int max = intArr[0];
        int loc=0;
        for (int j = 0; j < 256; j++) {
            if (intArr[j] > max) {
                max = intArr[j];
                loc = j;
            }
        }

        /*int max = tempData.charAt(0);
        int loc = 0;
        for (int j = 1; j < tempData.length(); j++) {
            if (intArr[tempData.charAt(j)] > max) {
                max = intArr[tempData.charAt(j)];
                loc = j;
            }
        }*/
        System.out.println("Char: " + (char)loc + " of freq: " + max);
    }

    private static void max(String num) {
    }

}
