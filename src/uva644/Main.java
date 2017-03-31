package uva644;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		// myWork.begin();
		// String str1 = "01";
		// String str2 = "011";
		// // System.out.println(str2.substring(0, 2));
		// List<String> codes = new ArrayList<String>();
		// codes.add(str1);
		// codes.add(str2);
		//
		// Trie t1 = new Trie(codes);
		// System.out.println(t1.isPrefix(str1));
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva644\\input.txt"));
		String line;
		List<String> codes = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if (!line.equals("9")) {
				codes.add(line);
			} else {
				System.out.println(codes);
				codes.removeAll(codes);
			}
		}
	}

	boolean isDecodeable(List<String> codes) {
		boolean flag = false;
		for (String code : codes) {
			String prefix = code;
			for (String codeAgain : codes) {
				if (!codeAgain.equals(prefix)) {
					if (isPrefixMatch(prefix, codeAgain)) {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}

	boolean isPrefixMatch(String prefix, String code) {
		boolean flag = false;
		int prefixLength = prefix.length();
		int codeLength = code.length();
		if (codeLength < prefixLength) {
			flag = false;
		} else {
			if (prefix.equals(code.substring(0, prefixLength))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
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
