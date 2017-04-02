package uva10420;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva10420\\input.txt"));
		String line;
		List<String> contries = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			int numberofLine = Integer.valueOf(line);
			for (int i = 0; i < numberofLine; i++) {
				contries.add(reader.readLine().split(" ")[0]);
			}
			// Collections.sort(contries);
		}
	}
}
