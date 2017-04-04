package uva10474;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws FileNotFoundException {
		// Scanner sc = new Scanner(new FileReader(
		// "F:\\imrul\\workspace\\UVA\\src\\uva10474\\input.txt"));
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<Integer>();
		int numberOfCase = 0;
		while (sc.hasNext()) {
			numberOfCase++;
			int listLength = sc.nextInt();
			int numberOfQuery = sc.nextInt();
			if (listLength == 0 && numberOfQuery == 0) {
				System.exit(0);
			}
			for (int i = 1; i <= listLength; i++) {
				numbers.add(sc.nextInt());
			}
			int query = 0;
			System.out.println("CASE# " + numberOfCase + ":");
			for (int j = 1; j <= numberOfQuery; j++) {
				query = sc.nextInt();
				searchNumber(query, numbers);
				if (j == numberOfQuery) {
					numbers.removeAll(numbers);
				}
			}
		}
	}

	void searchNumber(int query, List<Integer> numbers) {
		boolean flag = false;
		int position = 1;
		for (Integer number : numbers) {
			if (number == query) {
				flag = true;
				break;
			}
			position++;
		}
		if (flag) {
			System.out.println(query + " found at " + (position + 1));
		} else {
			System.out.println(query + " not found");
		}
	}
}
