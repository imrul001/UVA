package uva123;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva123\\input.txt"));
		String line;
		List<MyString> ignoreList = new ArrayList<MyString>();
		List<String> titles = new ArrayList<String>();
		List<MyString> words = new ArrayList<MyString>();
		boolean titleStart = false;
		while ((line = reader.readLine()) != null) {
			if (line.equals("::")) {
				titleStart = true;
			}
			if (titleStart && !line.equals("::")) {
				titles.add(line);
				String[] strArray = line.toLowerCase().split(" ");
				for (String str : strArray) {
					words.add(new MyString(str));
				}
			}
			if (!titleStart) {
				ignoreList.add(new MyString(line.toLowerCase()));
			}
		}
		solve(ignoreList, titles, words);
		System.exit(0);
	}

	private void solve(List<MyString> ignoreList, List<String> titles,
			List<MyString> words) {
		printList(ignoreList);
		printList(words);
		for (MyString s : ignoreList) {
			for (MyString str : words) {
				if (s.getWord().equals(str.getWord())) {
					words.remove(str);
				}
			}
		}
		printList(words);
	}

	void printList(List<MyString> list) {
		for (MyString object : list) {
			System.out.print(object.getWord() + " ");
		}
		System.out.println();
	}
}

class MyString implements Comparable {
	private String word;

	public MyString(String str) {
		this.word = str;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int compareTo(Object object) {
		MyString myString = (MyString) object;
		return this.getWord().toLowerCase().compareTo(myString.getWord());
	}
}