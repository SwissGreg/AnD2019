/*==============================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Find the largest square of equal integers 
 * 
 * Brute Force Implementation
 * 
 =============================================================================*/
import java.util.Scanner;

public class LargestSquare {
	public static void main(String[] args) {
		String input = "7\n" +
                "1 2 3 1 2 2 2\n" + 
                "4 5 6 2 2 2 2\n" + 
                "8 8 8 8 2 2 2\n" + 
                "8 8 8 8 3 0 9\n" + 
                "8 8 8 8 4 9 5\n" + 
                "8 8 8 8 2 3 2\n" + 
                "9 9 9 9 0 3 1";
		System.out.println(input);
		System.out.println(largestBlock(input));
	}
	public static int largestBlock(String string) {
		Scanner scan = new Scanner(string);
		int n = scan.nextInt();
		int[][] matrix = new int[n][n];
		int counter = 0;
		int rows = 0;
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<n;j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		int max = 0;
		boolean flag = false;
		for(int a = 0; a<n;a++) {
			for(int b = 0; b<n;b++) {
				
				for(int c = n-1; c>=a;c--) {
					for(int d = n-1; d>=b;d--) {
						flag = false;
						int num = matrix[a][b];
						for(int e = a; e<=c;e++) {
							for(int f = b; f<=d;f++) {
								int curr = matrix[e][f];
								if(curr != num) {
									flag = true;
									break;
								}
							}
							if(flag) {
								break;
							}
						}
						if(!flag && c-a == d-b && c-a > max) {
							max = c-a;
//							System.out.println(c+ " "+a +" "+ num);
//							System.out.println(d+ " "+b +" "+ num);
						}
					}
				}
			}
			
		}

		return max+1;
	}
}