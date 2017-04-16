package uva10079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			long numberOfCuts = Long.parseLong(line);
			if (numberOfCuts < 0) {
				break;
			}
			System.out.println(getMaximumNumberOfSlices(numberOfCuts));
		}
		System.exit(0);
	}

	private long getMaximumNumberOfSlices(long numberOfCuts) {
		return ((numberOfCuts * numberOfCuts) + numberOfCuts + 2) / 2;
	}
}
