package uva414;

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
		int numberOfLines;
		while ((numberOfLines = Integer.parseInt(reader.readLine())) != 0) {
			List<Input> inputSet = new ArrayList<Input>();
			int smallestBlank = 25;
			for (int i = 0; i < numberOfLines; i++) {
				String str = reader.readLine();
				int temp = getNumberOfBlank(str);
				smallestBlank = temp <= smallestBlank ? temp : smallestBlank;
				Input input = new Input(str, temp);
				inputSet.add(input);
			}
			System.out.println(getTotalBlank(inputSet, smallestBlank));

		}

	}

	int getTotalBlank(List<Input> inputSet, int smallestBlank) {
		int count = 0;
		for (Input input : inputSet) {
			count += (input.getBlank() - smallestBlank);
		}
		return count;
	}

	int getNumberOfBlank(String series) {
		int number = 0;
		for (int i = 0; i < series.length(); i++) {
			if (series.charAt(i) == 32) {
				number++;
			}
		}
		return number;
	}

}

class Input {
	String series;
	int blank;

	public Input(String series, int blank) {
		super();
		this.series = series;
		this.blank = blank;
	}

	public int getBlank() {
		return blank;
	}
}