package uva644;

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
		myWork.begin();
	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva644\\input.txt"));
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva644/input.txt"));

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<String> codes = new ArrayList<String>();
		int count = 0;
		while ((line = reader.readLine()) != null) {
			if (!line.equals("9")) {
				codes.add(line);
			} else {
				count++;
				if (isDecodable(codes)) {
					System.out.println("Set " + count
							+ " is not immediately decodable");
				} else {
					System.out.println("Set " + count
							+ " is immediately decodable");
				}
				codes.removeAll(codes);
			}
		}
	}

	boolean isDecodable(List<String> codes) {
		Trie trie = new Trie(codes);
		boolean flag = false;
		for (String code : codes) {
			if (trie.isPrefix(code)) {
				flag = true;
				break;
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
