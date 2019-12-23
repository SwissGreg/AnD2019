/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Merge Sort Implementation
 * 
 ========================================================================================================*/
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 5, 1, 6, 34, 11, 99, 45, 23, 324 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public static void mergeSort(int[] arr, int l, int r) {
		int m = l + (r - l) / 2;
		if (r - l <= 1) {

		} else {
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
		}
		merge(arr, l, r);
	}

	public static void merge(int[] arr, int l, int r) {
		int m = l + (r - l) / 2;
		int pointer1 = l;
		int pointer2 = m + 1;

		while (pointer2 <= r && pointer1 <= r && pointer1 < pointer2) {
			if (arr[pointer1] > arr[pointer2]) {
				swap(arr, pointer1, pointer2);
				pointer1++;
				swapDown(arr, pointer1, pointer2);
				pointer2++;
			} else {
				pointer1++;
			}
		}

	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void swapDown(int[] arr, int index1, int index2) {
		while (index2 > index1) {
			swap(arr, index2, index2 - 1);
			index2--;
		}
	}
}
