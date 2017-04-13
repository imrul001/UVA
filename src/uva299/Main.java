package uva299;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/linux/tutorial/UVA/src/uva299/input.txt"));
		String line;
		// while ((line = reader.readLine()) != null) {
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			int maxLength = Integer.parseInt(reader.readLine());
			String[] stringArray = new String[maxLength];
			stringArray = reader.readLine().split(" ");
			int[] array = new int[maxLength];
			int[] sortedArray = new int[maxLength];

			for (int k = 0; k < stringArray.length; k++) {
				array[k] = Integer.valueOf(stringArray[k]);
				sortedArray[k] = Integer.valueOf(stringArray[k]);
			}
			Arrays.sort(sortedArray);
			int swaps = 0;
			for (int j = 0; j < array.length; j++) {
				for (int l = j; l < array.length; l++) {
					if (array[j] > array[l]) {
						int temp = array[j];
						array[j] = array[l];
						array[l] = temp;
						swaps++;
					}
				}
			}
			System.out.println("swap " + swaps);
		}
		System.exit(0);

	}
}
