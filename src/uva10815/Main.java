package uva10815;

/**
 * @author imrul
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(
		// System.in));
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/linux/tutorial/UVA/src/uva10815/input.txt"));
		String line;
		List<String> words = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if (!"".equals(line.trim())) {
				String[] strArray = line.split(" ");
				Collections.addAll(words, cleanWords(strArray));
			}
		}
		printResult(getSortedUniqueWord(words));
		System.out.println("end of program");
	}

	String[] cleanWords(String[] dirtyWords) {
		String[] words = new String[dirtyWords.length];
		int count = 0;
		for (String str : dirtyWords) {
			words[count] = (str.replaceAll("[^a-zA-Z]", "").toLowerCase());
			count++;
		}
		return words;
	}

	Set<String> getSortedUniqueWord(List<String> words) {
		words.removeAll(Arrays.asList("", null));
		return new TreeSet(words);
	}

	void printResult(Set<String> sortedSet) {
		for (String word : sortedSet) {
			System.out.println(word);
		}
	}
}
