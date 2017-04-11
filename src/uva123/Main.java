package uva123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva123/input1.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<String> ignoreList = new ArrayList<String>();
		List<String> titles = new ArrayList<String>();
		List<String> CopyTitles = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		boolean titleStart = false;
		while ((line = reader.readLine()) != null) {
			if (line.equals("::")) {
				titleStart = true;
			}
			if (titleStart && !line.equals("::")) {
				titles.add(line);
				CopyTitles.add(line);
				Collections.addAll(words, line.toLowerCase().split(" "));
			}
			if (!titleStart) {
				ignoreList.add(line.toLowerCase());
			}
		}
		words.removeAll(ignoreList);
		Collections.sort(words);
		solve(titles, words, CopyTitles);
		System.exit(0);
	}

	private void solve(List<String> titles, List<String> words,
			List<String> copyTitles) {
		for (String word : words) {
			for (int i = 0; i < titles.size(); i++) {
				if (copyTitles.get(i).toLowerCase().contains(word)) {
					String element = copyTitles.get(i).toLowerCase()
							.replaceFirst(word, printSpace(word.length()));
					int StartingOffset = copyTitles.get(i).toLowerCase()
							.indexOf(word);
					copyTitles.add(i, element);
					copyTitles.remove(i + 1);
					printResult(word, titles, i, StartingOffset);
					// System.out.println(copyTitles);
					break;
				}
			}
		}
		System.out.println();
	}

	private void printResult(String word, List<String> titles, int i,
			int StartingOffSet) {
		String str = titles.get(i).toLowerCase();
		System.out.println(replaceCharAt(str, StartingOffSet,
				word.toUpperCase()));
	}

	static String printSpace(int size) {
		return new String(new char[size]).replace('\0', '.');
	}

	public static String replaceCharAt(String s, int pos, String word) {
		int length = word.length();
		return s.substring(0, pos) + word + s.substring(pos + length);
	}
}
