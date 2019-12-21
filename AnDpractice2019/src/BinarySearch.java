import java.util.Scanner;

/*
 * binarySearch which returns index of last element greater smaller than n
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(binSearch(arr, n));
	}

	public static int binSearch(int[] arr, int n) {
		int l = 0;
		int m = arr.length / 2;
		int r = arr.length - 1;
		if (n <= arr[0]) {
			return 0;
		} else if (n >= arr[arr.length - 1]) {
			return arr.length - 1;
		}
		while (true) {
			if (l == r - 1) {
				return l;
			} else if (arr[m] == n) {
				return m;
			} else if (arr[m] > n) {
				r = m;
				m = l + (r - l) / 2;
			} else {
				l = m;
				m = l + (r - l) / 2;
			}
		}
	}
}
