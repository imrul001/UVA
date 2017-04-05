package uva10474;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws NumberFormatException, IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva10474\\input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int numberOfCase = 0;
		List<Integer> marbels = new ArrayList<Integer>();
		String line;
		while ((line = reader.readLine()) != null) {
			numberOfCase++;
			int listLength = Integer.parseInt(line.split(" ")[0]);
			int numberOfQuery = Integer.parseInt(line.split(" ")[1]);
			if (listLength == 0 && numberOfQuery == 0) {
				System.exit(0);
			}
			for (int i = 0; i < listLength; i++) {
				marbels.add(Integer.parseInt(reader.readLine()));
			}
			Collections.sort(marbels);
			int query = 0;
			System.out.println("CASE# " + numberOfCase + ":");

			for (int j = 1; j <= numberOfQuery; j++) {
				query = Integer.parseInt(reader.readLine());
				int position = mySearch(query, marbels);
				if (position < 0) {
					System.out.println(query + " not found");
				} else {
					System.out.println(query + " found at " + (position + 1));
				}
				if (j == numberOfQuery) {
					marbels.removeAll(marbels);
				}
			}
		}
	}

	int binarySearch(int key, List<Integer> marbels) {
		int position = -1;
		int low = 0;
		int high = marbels.size() - 1;

		while (high >= low) {
			int middle = (low + high) / 2;
			if (marbels.get(middle) == key) {
				position = middle;
				break;
			}
			if (marbels.get(middle) < key) {
				low = middle + 1;
			}
			if (marbels.get(middle) > key) {
				high = middle - 1;
			}
		}
		return position;
	}

	int mySearch(int key, List<Integer> marbels) {
		int position = -1;
		for (int i = 0; i < marbels.size(); i++) {
			if (key < marbels.get(i)) {
				break;
			}
			if (key == marbels.get(i)) {
				position = i;
				break;
			}
		}
		return position;
	}
}