package uva10878;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva10878\\input.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			String cleaned = line.replaceAll("[_|]", "").replaceAll("[.]", "");
			if (cleaned.length() > 0) {
				System.out.print(getBinaryCount(cleaned));
			}
		}
	}

	char getBinaryCount(String str) {
		int sum = 0;
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'o') {
				sum += (int) Math.pow(2, str.length() - count);
			}
			count++;
		}
		return (char) sum;
	}
}
