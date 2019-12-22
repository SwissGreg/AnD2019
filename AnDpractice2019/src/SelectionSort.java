/*========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Selection Sort Implementation
 * 
 =========================================================================================================*/
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 102, 1 };
		selSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public static void selSort(int[] arr) {
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					index = j;
					min = arr[j];
				}
			}
			swap(arr, i, index);

		}

	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
