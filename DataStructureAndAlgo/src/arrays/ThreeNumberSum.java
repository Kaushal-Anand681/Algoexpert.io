package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array of Distinct Integer value and also gives a separate Integer value which is a Target Sum.
 * Write a method which will find the sum of three number present in that Array sums up to the Target Sum.
 * 
 * e.g -> [12,3,1,2,-6,5,-8,6]  ,   0   Answer = [[-8,2,6],[-8,3,5],[-6,1,5]]
 * 
 * */

public class ThreeNumberSum {

	public static void main(String[] args) {
		int[] problemArray = { 12, 3, 1, 2, -6, 5, -8, 6 };
		int targetSum = 0;
		ArrayList<ArrayList<Integer>> solutionArray = solution(problemArray, targetSum); // O(N>2) time, O(N) space
		if (solutionArray.isEmpty()) {
			System.out.println("No triplets Found");
		} else {
			System.out.println(solutionArray);
		}
	}

	private static ArrayList<ArrayList<Integer>> solution(int[] problemArray, int targetSum) {
		if (problemArray == null || problemArray.length == 0) {
			System.out.println("Please provide something in the array");
			return null;
		}
		Arrays.sort(problemArray);
		ArrayList<ArrayList<Integer>> finalSolution = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < problemArray.length - 2; i++) {
			int leftIdx = i + 1;
			int rightIdx = problemArray.length - 1;
			while (rightIdx > leftIdx) {
				int currentSum = problemArray[i] + problemArray[leftIdx] + problemArray[rightIdx];
				if (currentSum == targetSum) {
					ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
					tempArrayList.add(problemArray[i]);
					tempArrayList.add(problemArray[problemArray[leftIdx]]);
					tempArrayList.add(problemArray[problemArray[rightIdx]]);
					finalSolution.add(tempArrayList);
					leftIdx += 1;
					rightIdx -= 1;
				} else if (currentSum < targetSum) {
					leftIdx += 1;
				} else if (currentSum > targetSum) {
					rightIdx -= 1;
				}
			}
		}
		return finalSolution;
	}
}
