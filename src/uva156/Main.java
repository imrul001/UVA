package uva156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String args[]) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva156/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<String> words = new ArrayList<String>();
		List<String> lowercaseWord = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if (line.equals("#")) {
				for (String word : words) {
					lowercaseWord.add(word.toLowerCase().trim());
				}
				solve(lowercaseWord, words);
				System.exit(0);
			}
			Collections.addAll(words, line.replaceAll("\\s+", " ").split(" "));
		}
	}

	void solve(List<String> lowercaseWords, List<String> words) {
		List<String> resultList = new ArrayList<String>();
		boolean flag = false;
		int index = 0;
		for (String word : lowercaseWords) {
			int wordIndex = 0;
			for (int i = 0; i < lowercaseWords.size(); i++) {
				if (index != i && isSameWord(word, lowercaseWords.get(i))) {
					flag = false;
					break;
				} else {
					flag = true;
					wordIndex = index;
				}
			}
			index++;
			if (flag) {
				resultList.add(words.get(wordIndex));
			}
		}
		Collections.sort(resultList);
		for (String result : resultList) {
			System.out.println(result);
		}
	}

	boolean isSameWord(String firstStr, String secondStr) {
		char[] first = firstStr.toCharArray();
		char[] second = secondStr.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}
}
