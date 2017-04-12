package uva10008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva10008/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		List<Character> chars = new ArrayList<Character>();
		Set<Character> charSet = new HashSet<Character>(chars);
		// while ((line = reader.readLine()) != null) {
		int numberOfLines = Integer.parseInt(line);
		for (int i = 0; i < numberOfLines; i++) {
			String eachLine = reader.readLine();
			for (int j = 0; j < eachLine.length(); j++) {
				char check = eachLine.charAt(j);
				if (Character.isAlphabetic(check)) {
					chars.add(Character.toUpperCase(check));
					charSet.add(Character.toUpperCase(check));
				}
			}
		}
		Collections.sort(chars);
		List<Entry> entries = new ArrayList<Entry>();
		for (char searchCh : charSet) {
			int count = 0;
			int start = 0;
			for (char ch : chars) {
				if (searchCh == ch) {
					count++;
					start = 1;
				}
				if (searchCh != ch && start == 1) {
					start = 0;
					break;
				}
			}
			entries.add(new Entry(searchCh, count));
		}
		Collections.sort(entries);
		for (Entry entry : entries) {
			System.out.println(entry.getStr() + " " + entry.getCount());
		}
		System.exit(0);
	}
}

// }

class Entry implements Comparable<Entry> {
	private String str;
	private int count;

	public String getStr() {
		return str;
	}

	public int getCount() {
		return count;
	}

	public Entry(char searchCh, int count2) {
		super();
		this.str = String.valueOf(searchCh);
		this.count = count2;
	}

	public int compareTo(Entry o) {
		int value = o.count - this.count;
		if (value != 0) {
			return value;
		}
		return this.str.compareTo(o.str);
	}

}
