package arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of Distinct Integer value and also gives a separate Integer value which is a Target Sum.
 * Write a method which will find the sum of two number present in that Array sums up to the Target Sum.
 * 
 * e.g -> [3,5,-4,8,11,1,-1,6]  ,   10   Answer = [11,-1]
 * 
 * */
public class TwoNumberSum {

	public static void main(String[] args) {
		int[] problemArray = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum = 9;
		int[] solutionArray = solution1(problemArray, targetSum); //O(N) time, O(N) space
//		int[] solutionArray = solution2(problemArray, targetSum); // O(Nlog(N)) time, O(1) space
		if (solutionArray != null) {
			System.out.println(
					"Found " + solutionArray[0] + " and " + solutionArray[1] + " which sums up to " + targetSum);
		} else {
			System.out.println("Not found any pair with targetSum " + targetSum);
		}
	}

	private static int[] solution2(int[] problemArray, int targetSum) {
		if (problemArray == null || problemArray.length == 0) {
			System.out.println("Please provide something in the array");
			return null;
		}
		Arrays.sort(problemArray);
		int leftIdx = 0;
		int rightIdx = problemArray.length - 1;
		while (rightIdx > leftIdx) {
			if (problemArray[rightIdx] + problemArray[leftIdx] < targetSum) {
				leftIdx += 1;
			} else if (problemArray[rightIdx] + problemArray[leftIdx] > targetSum) {
				rightIdx -= 1;
			} else if (problemArray[rightIdx] + problemArray[leftIdx] == targetSum) {
				return new int[] { problemArray[leftIdx], problemArray[rightIdx] };
			} else {
				break;
			}
		}
		return null;
	}

	private static int[] solution1(int[] problemArray, int targetSum) {
		if (problemArray == null || problemArray.length == 0) {
			System.out.println("Please provide something in the array");
			return null;
		}
		HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
		for (int value : problemArray) {
			if (hashTable.containsKey(targetSum - value)) {
				return new int[] { value, targetSum - value };
			} else {
				hashTable.put(value, true);
			}
		}
		return null;
	}

}
