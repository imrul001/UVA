package uva445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;
		while ((line = reader.readLine()) != null) {
			List<String> list = new ArrayList<String>();
			List<String> preparedList = new ArrayList<String>();

			if (line.equals("")) {
				System.out.println("");
				continue;
			} else {
				list.add(line);
			}
			preparedList = getPreparedList(list);
			Solve(preparedList);
		}
	}

	void Solve(List<String> list) {
		for (String str : list) {
			int number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch;
				if (Character.isDigit(str.charAt(i))) {
					number += Character.getNumericValue(str.charAt(i));
				}
				if (Character.isLetter(str.charAt(i)) || str.charAt(i) == '*') {
					ch = str.charAt(i);
					if (ch == 'b') {
						ch = ' ';
					}
					printCharacter(number, ch);
					number = 0;
				}
			}
			System.out.println();
		}
	}

	List<String> getPreparedList(List<String> list) {
		List<String> preparedList = new ArrayList<String>();
		int startingIndex = 0;
		int i;
		boolean start = false;
		for (String str : list) {
			for (i = 0; i < str.length(); i++) {
				if (Character.isLetter(str.charAt(i))
						|| Character.isDigit(str.charAt(i))) {
					if (!start) {
						start = true;
						startingIndex = i;
					}
				}
				if (str.charAt(i) == '!') {
					preparedList.add(str.substring(startingIndex, i));
					startingIndex = 0;
					start = false;
				}
			}
			if (start) {
				preparedList.add(str.substring(startingIndex, i));
				startingIndex = 0;
				start = false;
			}
		}
		return preparedList;
	}

	void printList(List<String> list) {
		for (String str : list) {
			System.out.println(str);
		}
	}

	void printCharacter(int time, char ch) {
		for (int i = 0; i < time; i++) {
			System.out.print(ch);
		}
	}
}