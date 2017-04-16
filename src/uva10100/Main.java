package uva10100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.hasan.testcode.Trie;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva10100\\input.txt"));
		String line;
		int testCase = 1;
		while ((line = reader.readLine()) != null) {
			String searchKey = reader.readLine();
			if (searchKey.length() > 0) {
				solve(line, searchKey, testCase);
			} else {
				System.out.println(testCase + ". Blank!");
			}
			testCase++;
		}
	}

	private void solve(String line, String searchKey, int testCase) {
		List<String> wordList = getCleanedData(line.split(" "));
		List<String> serialKeys = getCleanedData(searchKey.split(" "));
		Trie trie = new Trie(wordList);
		int longestLength = 0;
		StringBuffer sb = new StringBuffer();
		for (String str : serialKeys) {
			sb.append(str);
			if (trie.isPrefix(sb.toString())) {
				longestLength++;
			} else {
				break;
			}
		}
		System.out.println(testCase + ". Length of longest match: "
				+ longestLength);
	}

	List<String> getCleanedData(String[] words) {
		List<String> wordList = new ArrayList<String>();
		for (String str : words) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				if (Character.isAlphabetic(str.charAt(i))) {
					sb.append(str.charAt(i));
				} else {
					sb.append(" ");
				}
			}
			wordList.add(sb.toString());
		}
		return wordList;
	}
}
