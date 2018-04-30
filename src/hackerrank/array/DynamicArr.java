package hackerrank.array;

import hackerrank.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArr {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			// Take input for sequences
			int noOfSeq = in.nextInt();
			if (noOfSeq <= 0 || noOfSeq > 100000) {
				return;
			}
			List<List<Integer>> seqLists = new ArrayList<List<Integer>>();
			for (int i = 0; i < noOfSeq; i++) {
				seqLists.add(new ArrayList<>());
			}
			// Last Answer
			int lastAnswer = 0;
			// Take input queries
			int noOfQueries = in.nextInt();
			if (noOfQueries <= 0 || noOfQueries > 100000) {
				return;
			}
			// Calculate the sequences
			int queryType, xValue, yValue, seqIndex, lastAnsIndex;
			for (int i = 0; i < noOfQueries; i++) {
				queryType = in.nextInt();
				xValue = in.nextInt();
				yValue = in.nextInt();

				if (isValid(xValue) && isValid(yValue)) {
					seqIndex = (xValue ^ lastAnswer) % noOfSeq;
					// System.out.println("QueryType >> Index: " + seqIndex);
					//				writeToFile("123");

					switch (queryType) {
					case 1:
						seqLists.get(seqIndex).add(yValue);
						break;
					case 2:
						if (seqLists.get(seqIndex).size() > 0) {
							lastAnsIndex = yValue % seqLists.get(seqIndex).size();
							// System.out.println("QueryType2 >> LastAnsIndex: " +
							// lastAnsIndex);
							lastAnswer = seqLists.get(seqIndex).get(lastAnsIndex);
							// System.out.println("QueryType2 >> LastAns: " +
							// lastAnswer);				
						}
						Logger.log(String.valueOf(lastAnswer));
						break;
					}
				}
			} 
		} catch (Exception e) {
			Logger.log(e.getMessage());
		}
	}

	private static boolean isValid(int a) {
		if (a >= 0 && a <= 1000000000) {
			return true;
		}
		return false;
	}
}
