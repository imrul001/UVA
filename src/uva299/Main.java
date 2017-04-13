package uva299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva299/input.txt"));
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva299\\input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			int maxLength = Integer.parseInt(reader.readLine());
			String[] stringArray = reader.readLine().split(" ");
			int length = stringArray.length;
			int[] array = new int[length];
			int[] sortedArray = new int[length];

			for (int k = 0; k < stringArray.length; k++) {
				array[k] = Integer.valueOf(stringArray[k]);
				sortedArray[k] = Integer.valueOf(stringArray[k]);
			}
			quickSort(sortedArray, 0, sortedArray.length - 1);
			System.out.println("Optimal train swapping takes "
					+ solve(array, sortedArray) + " swaps.");
		}
		reader.close();
		System.exit(0);
	}

	int solve(int[] array, int[] sortedArray) {
		int swaps = 0;
		for (int x = 0; x < array.length - 1;) {
			if (array[x] == sortedArray[x]) {
				x++;
			} else {
				for (int y = 0; y < array.length - 1; y++) {
					int z = y + 1;
					if (z > array.length - 1) {
						break;
					}
					for (;;) {
						if (array[y] > array[z]) {
							int temp = array[y];
							array[y] = array[z];
							array[z] = temp;
							swaps++;
						} else {
							break;
						}
					}
				}
			}
		}
		return swaps;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
		if (low >= high)
			return;
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}
}