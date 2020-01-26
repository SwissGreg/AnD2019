/*====================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Exercise     : AD8H13P3.Flea_Market
 * Template URL : https://www.cadmo.ethz.ch
    /education/lectures/HS18/DA/uebungen/AD8H13P3.Flea_Market.zip
 * 
=================================================================================== */
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Main {

	public static void read_and_solve(InputStream in, PrintStream out) {

		Scanner scanner = new Scanner(in);

		int tests = scanner.nextInt();
		for (int t = 0; t < tests; t += 1) {
			//
			// Scan n, S, W
			//
			int n = scanner.nextInt();
			int S = scanner.nextInt();
			int W = scanner.nextInt();
			//
			// Allocate space
			//
			int[] space = new int[n + 1];
			int[] weight = new int[n + 1];
			int[] price = new int[n + 1];
			//
			// Scan the values
			//
			for (int i = 1; i <= n; i += 1) {
				space[i] = scanner.nextInt();
				weight[i] = scanner.nextInt();
				price[i] = scanner.nextInt();
			}
			//
			// Provide your solution here
			//
			int[][][] dp = new int[n + 1][S+1][W + 1];
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < S + 1; j++) {
					for (int k = 0; k < W + 1; k++) {
						if (i == 0 && j == 0) {
							dp[i][j][k] = 0;
						}else if(i == 0) {
							dp[i][j][k] = Integer.MIN_VALUE;
						}
						else if (j - space[i] >= 0 && k - weight[i] >= 0) {
							dp[i][j][k] += Math.max(dp[i - 1][j - space[i]][k - weight[i]] + price[i], dp[i - 1][j][k]);
						} else if (j - space[i] < 0 && k - weight[i] >= 0) {
							dp[i][j][k] += Math.max(dp[i - 1][0][k - weight[i]] + price[i], dp[i - 1][j][k]);

						} else {
							dp[i][j][k] += dp[i - 1][j][k];
						}
					}
				}
			}
			out.println(dp[n][S][W]);
		}

		scanner.close();
	}

	//
	// Do not modify the main method, and keep the method read_and_solve
	//
	public static void main(String[] args) {
		read_and_solve(System.in, System.out);
	}
}