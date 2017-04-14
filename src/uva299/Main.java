package uva299;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// Scanner sc = new Scanner(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva299/input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int maxLength = sc.nextInt();
			int[] array = new int[maxLength];
			for (int x = 0; x < maxLength; x++) {
				array[x] = sc.nextInt();
			}
			System.out.println("Optimal train swapping takes "
					+ solve(array, maxLength) + " swaps.");
		}
		System.exit(0);
	}

	int solve(int[] array, int maxLength) {
		int swaps = 0;
		for (int i = 0; i < maxLength; i++) {
			for (int j = i + 1; j < maxLength; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					swaps++;
				}
			}
		}
		return swaps;
	}
}