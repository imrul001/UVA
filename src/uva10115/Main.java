package uva10115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();

	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva10115\\input1.txt"));

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			int numberOfCases = Integer.valueOf(line);
			if (numberOfCases == 0) {
				System.exit(0);
			}
			List<String> find = new ArrayList<String>();
			List<String> replaceBy = new ArrayList<String>();
			for (int i = 0; i < numberOfCases; i++) {
				find.add(reader.readLine());
				replaceBy.add(reader.readLine());
			}
			String input = reader.readLine();
			System.out.println(automaticEdit(input, find, replaceBy));
		}
	}

	String automaticEdit(String line, List<String> find, List<String> replaceBy) {
		List<String> result = new ArrayList<String>();
		result.add(line);
		int index = 0, i = 0;
		for (String findString : find) {
			for (;;) {
				if (findInString(findString, result.get(index))) {
					result.add(result.get(index).replaceFirst(find.get(i),
							replaceBy.get(i)));
					index++;
				} else {
					i++;
					break;
				}
			}
		}
		return result.get(result.size() - 1);
	}

	boolean findInString(String word, String text) {
		return text.indexOf(word) > -1;
	}
}
