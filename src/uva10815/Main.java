package uva10815;

/**
 * @author imrul
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva10815/input.txt"));
		String line;
		List<String> words = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			String word = "";
			for (int i = 0; i < line.length(); i++) {
				if (Character.isLetter(line.charAt(i))) {
					word += Character.toLowerCase(line.charAt(i));
				} else {
					if (word.length() > 0) {
						words.add(word);
					}
					word = "";
				}
				if (i == line.length() - 1 && word.length() > 0) {
					words.add(word);
				}
			}
		}
		Collections.sort(words);
		printResult(getSortedUniqueWord(words));
	}

	void printResult(Set<String> sortedList) {
		for (String word : sortedList) {
			System.out.println(word);
		}
	}

	Set<String> getSortedUniqueWord(List<String> words) {
		words.removeAll(Arrays.asList("", null));
		return new TreeSet(words);
	}
}
