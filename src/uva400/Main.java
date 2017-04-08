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
			Collections.sort(fileNames);
			solveRewrite(fileNames, maxNameLength);
		}
	}

	private void solveRewrite(List<MyString> fileNames, int maxNameLength) {
		// maximum number of possible columns
		float maxNumber0fColumns = ((60) / (maxNameLength + 2));
		float numberOfFiles = (float) fileNames.size();
		int row = 0, column = 0;
		float temp = numberOfFiles / maxNumber0fColumns;
		if (numberOfFiles % maxNumber0fColumns != 0) {
			temp = temp + 1;
		}
		row = (int) temp;
		if (numberOfFiles % row != 0) {
			column = (int) (numberOfFiles / row) + 1;
		} else {
			column = (int) (numberOfFiles / row);
		}
		printResult(fileNames, row, column, maxNameLength + 2);
	}

	void printResult(List<MyString> fileNames, int row, int column,
			int maxLength) {
		System.out.println(fileNames.size() + " " + row + " " + column + " "
				+ maxLength);
		System.out
				.println("------------------------------------------------------------");
		int count = 0;
		for (int i = 0; i < row; i++) {
			count++;
			String str1 = fileNames.get(i).getFileName();
			System.out.print(str1 + " " + i
					+ printSpace(maxLength - str1.length()));
			int index = i + row;
			for (int j = 0; j < column - 1; j++) {
				count++;
				if (index >= fileNames.size()) {
					break;
				}
				String str2 = fileNames.get(index).getFileName();
				if (count == column) {
					System.out.print(str2 + " " + index
							+ printSpace((maxLength - 2) - str2.length()));
				} else {
					System.out.print(str2 + " " + index
							+ printSpace(maxLength - str2.length()));
				}
				index = index + row;
			}
			count = 0;
			System.out.println();
		}
	}

	void printResultRewrite(List<MyString> fileNames, int row, int column,
			int maxLength) {
		System.out
				.println("------------------------------------------------------------");
		int columnCount = 0;
		for (int i = 0; i < row; i++) {
			columnCount++;
			String name1 = fileNames.get(i).getFileName();
			System.out.print(name1 + printSpace(maxLength - name1.length()));
			int index = i + row;
			for (int j = 0; j < column - 1; j++) {
				columnCount++;
				if (index >= fileNames.size()) {
					break;
				}
				String name2 = fileNames.get(index).getFileName();
				if (columnCount == column) {
					System.out.print(name2
							+ printSpace((maxLength - 2) - name2.length()));
				} else {
					System.out.print(name2
							+ printSpace(maxLength - name2.length()));
				}
				index = index + row;
				columnCount = 0;
			}
			System.out.println();
		}
	}

	static String printSpace(int size) {
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