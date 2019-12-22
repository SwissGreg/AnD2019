/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Insertion Sort Implementation
 * 
 =========================================================================================================*/
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 1, 89, 100, 2, 64, 23, 37, 0, 129 };

		insSort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void insSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int n = arr[i];
			int index = binSearch(arr, 0, i - 1, n);
			restore(arr, index + 1, i);
		}
	}

	public static int binSearch(int[] arr, int l, int r, int n) {
		if (n < arr[l]) {
			return l - 1;
		} else if (arr[r] < n) {
			return r;
		} else {
			int m = l + (r - l) / 2;
			if (arr[m] > n) {
				return binSearch(arr, l, m, n);
			} else {
				if (l == r - 1) {
					return m;
				} else {
					return binSearch(arr, m, r, n);
				}
			}
		}

	}

	public static void restore(int[] arr, int l, int r) {
		for (int i = l; i < r; i++) {
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
		}
	}
}
