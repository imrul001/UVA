package uva10050;

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
		// "/home/linux/tutorial/UVA/src/uva10050/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;

		while ((line = reader.readLine()) != null) {
			int testCases = Integer.parseInt(line);
			for (int i = 0; i < testCases; i++) {
				int timeLine = Integer.parseInt(reader.readLine());
				int numberOfParties = Integer.parseInt(reader.readLine());
				int[][] twoDArray = new int[numberOfParties + 1][timeLine + 1];
				int[] h = new int[numberOfParties + 1];
				for (int j = 1; j <= numberOfParties; j++) {
					h[j] = Integer.parseInt(reader.readLine());
					for (int k = 1; k <= timeLine; k++) {
						if (k % h[j] == 0) {
							twoDArray[j][k] = 1;
						} else {
							twoDArray[j][k] = 0;
						}
					}
				}
				// print2DArray(twoDArray, numberOfParties, timeLine);
				System.out.println(solve(twoDArray, timeLine, numberOfParties));
			}
			System.exit(0);
		}
	}

	int solve(int[][] array, int column, int row) {
		int wastedDays = 0;
		int friCounter = 6;
		int satCounter = 7;
		for (int j = 1; j <= column; j++) {
			if ((j != friCounter) && (j != satCounter)) {
				int sum = 0;
				for (int k = 1; k <= row; k++) {
					sum = sum + array[k][j];
				}
				if (sum > 0) {
					wastedDays++;
				}
			}
			if (j == friCounter) {
				friCounter += 7;
			}
			if (j == satCounter) {
				satCounter += 7;
			}
		}
		return wastedDays;
	}

	void print2DArray(int[][] array, int row, int column) {
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
