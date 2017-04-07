package uva156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main_Trie {
	public static void main(String args[]) throws IOException {
		Main_Trie myWork = new Main_Trie();
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
		Trie trie = new Trie(lowercaseWords);
		List<String> resultList = new ArrayList<String>();
		for (String word : lowercaseWords) {
			boolean flag = false;
			int index = 0;
			Set<String> permulatedWords = generatePerm(word);
			permulatedWords.remove(word);
			for (String permulatedWord : permulatedWords) {
				if (trie.contains(permulatedWord)) {
					flag = false;
					break;
				} else {
					flag = true;
					index = lowercaseWords.indexOf(word);
				}
			}
			if (flag) {
				resultList.add(words.get(index));
			}
		}
		Collections.sort(resultList);
		for (String str : resultList) {
			System.out.println(str);
		}
	}

	public static Set<String> generatePerm(String input) {
		Set<String> set = new HashSet<String>();
		if (input == "")
			return set;
		Character a = input.charAt(0);
		if (input.length() > 1) {
			input = input.substring(1);
			Set<String> permSet = generatePerm(input);
			for (String x : permSet) {
				for (int i = 0; i <= x.length(); i++) {
					set.add(x.substring(0, i) + a + x.substring(i));
				}
			}
		} else {
			set.add(a + "");
		}
		return set;
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
