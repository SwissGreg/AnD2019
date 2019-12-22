/*========================================================================================================
 * Author: Gregory Rozanski
 * 
 * Binary Search Implementation
 * 
 * recursive
 * iterative
 * 
 =========================================================================================================*/
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
		recursiveBinary(arr, 0, arr.length, 1);
		recursiveBinary(arr, 0, arr.length, 3);
		recursiveBinary(arr, 0, arr.length, 5);
		recursiveBinary(arr, 0, arr.length, 7);
		recursiveBinary(arr, 0, arr.length, 9);
		recursiveBinary(arr, 0, arr.length, 11);
		recursiveBinary(arr, 0, arr.length, 13);
		recursiveBinary(arr, 0, arr.length, 15);
		recursiveBinary(arr, 0, arr.length, 17);
		recursiveBinary(arr, 0, arr.length, -1);
		recursiveBinary(arr, 0, arr.length, 2);
		recursiveBinary(arr, 0, arr.length, 4);
		recursiveBinary(arr, 0, arr.length, 6);
		recursiveBinary(arr, 0, arr.length, 8);
		recursiveBinary(arr, 0, arr.length, 10);
		recursiveBinary(arr, 0, arr.length, 12);
		recursiveBinary(arr, 0, arr.length, 14);

		iterativeBinary(arr, 0, arr.length, 1);
		iterativeBinary(arr, 0, arr.length, 3);
		iterativeBinary(arr, 0, arr.length, 5);
		iterativeBinary(arr, 0, arr.length, 7);
		iterativeBinary(arr, 0, arr.length, 9);
		iterativeBinary(arr, 0, arr.length, 11);
		iterativeBinary(arr, 0, arr.length, 13);
		iterativeBinary(arr, 0, arr.length, 15);
		iterativeBinary(arr, 0, arr.length, 17);
		iterativeBinary(arr, 0, arr.length, -1);
		iterativeBinary(arr, 0, arr.length, 2);
		iterativeBinary(arr, 0, arr.length, 4);
		iterativeBinary(arr, 0, arr.length, 6);
		iterativeBinary(arr, 0, arr.length, 8);
		iterativeBinary(arr, 0, arr.length, 10);
		iterativeBinary(arr, 0, arr.length, 12);
		iterativeBinary(arr, 0, arr.length, 14);
	}

	public static void recursiveBinary(int[] arr, int l, int r, int n) {
		int m = l + (r - l) / 2;
		if (arr[m] == n) {
			System.out.println(m);
		} else if (m == l) {
			System.out.println(-1);
		} else if (arr[m] < n) {
			recursiveBinary(arr, m, r, n);
		} else {
			recursiveBinary(arr, l, m, n);
		}
	}

	public static void iterativeBinary(int[] arr, int l, int r, int n) {
		while (true) {
			int m = l + (r - l) / 2;
			if (arr[m] == n) {
				System.out.println(m);
				break;
			} else if (m == l) {
				System.out.println(-1);
				break;
			} else if (arr[m] < n) {
				l = m;
			} else {
				r = m;
			}
		}
	}
}
