package uva494;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author imrul
 * 
 */
class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(getWordCount(line));
		}
	}

	int getWordCount(String line) {
		int wordCount = 0;
		String[] array = line.split(" ");
		for (int i = 0; i < array.length; i++) {
			wordCount += countWord(array[i]);
		}
		return wordCount;
	}

	int countWord(String str) {
		int count = 0;
		boolean start = false;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				if (!start) {
					count++;
					start = true;
				}
			} else {
				start = false;
			}
		}
		return count;
	}
}