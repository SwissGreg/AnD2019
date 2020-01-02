/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Longest Common Subsequence Implementation
 * 
 * returns the length of the longest common subsequence between two strings
 * 
 * Does not output the LIS itself
 =========================================================================================================*/

import java.util.Scanner;
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			String one = scan.next();
			String two;
			if (one.equals("0")) {
				break;
			} else {
				two = scan.next();
			}
			System.out.println(lcs(one, two));
		}

	}

	public static int lcs(String s1, String s2) {
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		int[][] matrix = new int[first.length + 1][second.length + 1];
		matrix[0][0] = 0;
		for (int i = 1; i < matrix.length; i++) {
			matrix[i][0] = 0;
		}
		for (int i = 1; i < matrix[0].length; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 1; i <= s1.length(); i++) {

			for (int j = 1; j <= s2.length(); j++) {
				int a = 0;
				if (first[i - 1] == second[j - 1]) {
					a = 1;
				}
				matrix[i][j] = Math.max(matrix[i - 1][j - 1] + a, Math.max(matrix[i - 1][j], matrix[i][j - 1]));
			}
		}
		return matrix[first.length][second.length];
	}
}
