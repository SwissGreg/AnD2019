/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Iterative Merge Sort Implementation
 * 
 * using O(n) extra memory
 * 
 ========================================================================================================*/
public class MergeSortIterative {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 1, 99, 34, 123, 10, 12 };
		arr = mergeSortIterative(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] mergeSortIterative(int[] array, int l, int r) {
		if (r - l < 2 || array.length == 0) {

		} else {
			int m = l + (r - l) / 2;
			mergeSortIterative(array, l, m);
			mergeSortIterative(array, m + 1, r);
		}
		if (array.length != 0) {
			return merge(array, l, r);
		} else {
			return new int[0];
		}

	}

	public static int[] merge(int[] arr, int l, int r) {
		int[] result = new int[r - l + 1];
		int index = 0;
		int left = l;
		int middle = l + (r - l) / 2;
		int right = middle + 1;
		while (left <= middle && right <= r) {
			if (arr[left] < arr[right]) {
				result[index] = arr[left];
				index++;
				left++;
			} else {
				result[index] = arr[right];
				index++;
				right++;
			}
		}

		while (left <= middle) {
			result[index] = arr[left];
			left++;
			index++;
		}
		while (right <= r) {
			result[index] = arr[right];
			right++;
			index++;
		}
		for (int i = 0; i < result.length; i++) {
			arr[l + i] = result[i];
		}
		return arr;
	}
}
