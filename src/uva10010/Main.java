/**
 * 
 */
package uva10010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author imrul
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	/**
	 * @throws IOException
	 * 
	 */
	private void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/imrul/eclipseProjects/UVA/src/uva10010/input.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			int testCases = Integer.parseInt(line);
			for (int i = 0; i < testCases; i++) {
				reader.readLine();
				String dimention[] = reader.readLine().split(" ");
				int row = Integer.parseInt(dimention[0]);
				int column = Integer.parseInt(dimention[1]);
				char dataArray[][] = new char[row + 1][column + 1];
				for (int x = 1; x <= row; x++) {
					char[] lineArray = reader.readLine().toCharArray();
					int c = 0;
					for (int y = 1; y <= column; y++) {
						dataArray[x][y] = lineArray[c];
						c++;
					}
				}
				int numberOfWord = Integer.parseInt(reader.readLine());
				String word[] = new String[numberOfWord];
				for (int k = 0; k < numberOfWord; k++) {
					word[k] = reader.readLine();
				}

				printDataArray(dataArray);
				printArray(word);
			}
		}
	}

	void printDataArray(char[][] array) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 11; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	void printArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
