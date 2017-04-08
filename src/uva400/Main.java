package uva400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva400\\input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
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
			solve(fileNames, maxNameLength);
		}
	}

	void solve(List<MyString> fileNames, int maxNameLength) {
		int maxNumber0fColumns = (62 / (maxNameLength + 2));
		int numberOfFiles = fileNames.size();
		int row = 0, column = 0;
		if (numberOfFiles % maxNumber0fColumns != 0) {
			row = (numberOfFiles / maxNumber0fColumns) + 1;
		} else {
			row = numberOfFiles / maxNumber0fColumns;
		}
		if (numberOfFiles % row != 0) {
			column = (numberOfFiles / row) + 1;
		} else {
			column = (numberOfFiles / row);
		}
		printResult(fileNames, row, column, maxNameLength + 2);
	}

	void printResult(List<MyString> fileNames, int row, int column,
			int maxLength) {
		System.out
				.println("------------------------------------------------------------");
		int count = 0;
		for (int i = 0; i < row; i++) {
			count++;
			String str1 = fileNames.get(i).getFileName();
			System.out.print(str1 + printSpace(maxLength - str1.length()));
			int index = i + row;
			for (int j = 0; j < column - 1; j++) {
				count++;
				if (index >= fileNames.size()) {
					break;
				}
				String str2 = fileNames.get(index).getFileName();
				if (count == column) {
					System.out.print(str2
							+ printSpace((maxLength - 2) - str2.length()));
				} else {
					System.out.print(str2
							+ printSpace(maxLength - str2.length()));
				}
				index = index + row;
			}
			count = 0;
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