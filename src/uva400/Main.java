package uva400;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva400\\input.txt"));
		// BufferedReader reader = new BufferedReader(new InputStreamReader(
		// System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			int numberOfFiles = Integer.parseInt(line);
			List<MyString> fileNames = new ArrayList<MyString>();
			int maxNameLength = 0;
			for (int i = 0; i < numberOfFiles; i++) {
				String fileName = reader.readLine();
				int temp = fileName.length();
				if (temp > maxNameLength) {
					maxNameLength = temp;
				}
				fileNames.add(new MyString(fileName));
			}
			solveRewrite(fileNames, maxNameLength);
			fileNames.removeAll(fileNames);
		}
	}

	private void solveRewrite(List<MyString> fileNames, int maxNameLength) {
		// maximum number of possible columns
		float maxNumber0fColumns = ((60) / (maxNameLength + 2));
		float numberOfFiles = (float) fileNames.size();
		int row = 0, column = 0;
		float checkRow = 100;
		float index = maxNumber0fColumns;
		for (float i = index; i > 0; i--) {
			float temp = numberOfFiles / i;
			if (numberOfFiles % i != 0) {
				temp = temp + 1;
			}
			if (temp < checkRow) {
				checkRow = temp;
				row = (int) checkRow;
				column = (int) i;
			} else {
				break;
			}
		}
		Collections.sort(fileNames);
		printResult(fileNames, row, column, maxNameLength + 2);
	}

	void printResult(List<MyString> fileNames, int row, int column,
			int maxLength) {
		System.out
				.println("------------------------------------------------------------");
		for (int i = 0; i < row; i++) {
			String str1 = fileNames.get(i).getFileName();
			System.out.print(str1 + printSpaceCheck(maxLength - str1.length()));
			int index = i + row;
			for (int j = 0; j < column - 1; j++) {
				if (index >= fileNames.size()) {
					break;
				}
				String str2 = fileNames.get(index).getFileName();
				System.out.print(str2
						+ printSpaceCheck(maxLength - str2.length()));
				index = index + row;
			}
			System.out.println();
		}
	}

	static String printSpaceCheck(int size) {
		return new String(new char[size]).replace('\0', ' ');
	}

}

class MyString implements Comparable<MyString> {
	private String fileName;

	public MyString(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public int compareTo(MyString object) {
		return this.fileName.compareTo(object.fileName);
	}
}