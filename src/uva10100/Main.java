package uva10100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		// myWork.begin();
		String line = "&The@name}document:provides late-breaking)))information*";
		System.out.println(getCleanedDataReWrite(line.toLowerCase()));
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(
		// new
		// FileReader("F:\\imrul\\workspace\\UVA\\src\\uva10100\\input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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

	// This method should be rewritten based on requirement
	private void solve(String line, String searchKey, int testCase) {
		List<String> wordList = getCleanedData(line.toLowerCase().split(" "));
		List<String> serialKeys = getCleanedData(searchKey.toLowerCase().split(" "));
		Trie trie = new Trie(wordList);
		int longestLength = 0;
		StringBuffer sb = new StringBuffer();
		for (String str : serialKeys) {
			if (longestLength > 0) {
				sb.append(" " + str.trim());
			} else {
				sb.append(str.trim());
			}
			if (trie.isPrefix(sb.toString()) || trie.contains(sb.toString())) {
				longestLength++;
			} else {
				break;
			}
		}
		System.out.println(testCase + ". Length of longest match: " + longestLength);
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

	// Rewritten method to clear string and get each word separately
	static List<String> getCleanedDataReWrite(String line) {
		List<String> wordList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < line.length(); i++) {
			if (!Character.isAlphabetic(line.charAt(i))) {
				if (sb.length() > 0) {
					wordList.add(sb.toString().trim());
				}
				sb.delete(0, sb.length());
			} else {
				sb.append(line.charAt(i));
			}
			if (i == line.length() - 1 && sb.length() > 0) {
				wordList.add(sb.toString().trim());
			}
		}
		return wordList;
	}

}

class Trie extends TreeSet<String> {
	private List<String> codes = new ArrayList<String>();

	public Trie(Collection<String> codes) {
		super(codes);
	}

	public boolean isPrefix(String prefix) {
		String nextWord = ceiling(prefix);
		if (nextWord == null) {
			return false;
		}
		if (nextWord.equals(prefix)) {
			Set<String> tail = tailSet(nextWord, false);
			if (tail.isEmpty()) {
				return false;
			}
			nextWord = tail.iterator().next();
		}
		return nextWord.startsWith(prefix);
	}

	public boolean contains(String word) {
		return super.contains(word);
	}
}
