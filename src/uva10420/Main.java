package uva10420;

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

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva10420/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<String> countries = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			int numberofLine = Integer.valueOf(line);
			for (int i = 0; i < numberofLine; i++) {
				countries.add(reader.readLine().split(" ")[0]);
			}
			Collections.sort(countries);
			getCount(countries);
		}
	}

	void getCount(List<String> countries) {
		List<String> temp = new ArrayList<String>();
		temp.add(countries.get(0));
		int count = 0;
		for (String country : countries) {
			if (country.equals(temp.get(0))) {
				count++;
			} else {
				System.out.println(temp.get(0) + " " + count);
				count = 1;
				temp.remove(0);
				temp.add(country);
			}
		}
		System.out.println(temp.get(0) + " " + count);
	}
}
