/*=============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Längste Baguette der Welt
 * 
 * PROBLEM DESCRIPTION: A baguette of length l should be sold for maximal profit
 * every peice of length li can be sold for a profit of pi (i element of N)
 * 
 * BEISPIEL:  l = 121
 * l1 = 50 p1 = 25
 * l2 = 26 p2 = 14
 * l3 = 20 p3 = 10
 * 
 * Maximal profit = 3*14 + 2*10 = 62
 * 
 * SOLUTION:
 * 
 * We use a 1 Dimensional DP table of size l
 * DP[i] = maximum profit of a baguette of length i
 * DP[i] = max(DP[i-1],DP[i-li] + pi)
 * --> either we cant slice the bread hence its value is the same or we can make another cut and increase the value
 * 
 * the solution is in DP[l]
 * time complexity O(l*i) (i is the number of possible cut sizes)
 ===============================================================================================================================*/
public class LangsteBaguette {

	public static void main(String[] args) {
		int l = 121;
		int[] sizes = {50,26,20};
		int[] prices = {25,14,10};
		System.out.println(baguette(l,sizes,prices));

	}
	
	public static int baguette(int l,int[] sizes, int[] prices) {
		int[] length = new int[l+1];
		length[0] = 0;
		for(int i = 1; i<l+1;i++) {
			for(int j = 0; j<sizes.length;j++) {
				int sol = 0;
				int dist = 0;
				if(i-sizes[j] >= 0) {
					sol = prices[j];
					dist = sizes[j];
				}
				length[i] = Math.max(length[i-1], Math.max(length[i-dist] + sol,length[i]));
			}
		}
		return length[l-1];
	}
}
