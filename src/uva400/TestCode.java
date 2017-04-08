package uva400;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCode {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva400\\input.txt"));

		String line;
		while ((line = reader.readLine()) != null) {
			int numberOfFiles = Integer.parseInt(line);
			String[] fileNames = new String[numberOfFiles];
			for (int i = 0; i < numberOfFiles; i++) {
				fileNames[i] = reader.readLine();
			}
			ArrayList.sort(fileNames);
		}
	}
}
