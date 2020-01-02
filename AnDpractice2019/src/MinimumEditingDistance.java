/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Minimum Editing distance Implementation
 * 
 * returns the number of operations needed to convert one string into another
 * 
 ========================================================================================================*/

import java.util.Scanner;

public class MinimumEditingDistance {

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
			System.out.println(med(one, two));

		}
	}

	public static int med(String one, String two) {
		char[] first = one.toCharArray();
		char[] second = two.toCharArray();
		int[][] matrix = new int[first.length + 1][second.length + 1];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = i;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				int a = 0;
				if (first[i - 1] == second[j - 1]) {
					a = 1;
				}
				matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1 - a,
						Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1));
			}
		}

		return matrix[first.length][second.length];
	}

}
